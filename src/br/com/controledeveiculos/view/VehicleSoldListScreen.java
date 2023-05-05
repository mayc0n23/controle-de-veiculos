package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import br.com.controledeveiculos.components.MenuBar;
import br.com.controledeveiculos.entity.Archive;
import br.com.controledeveiculos.entity.Vehicle;
import br.com.controledeveiculos.exception.FailedToDeleteFileException;
import br.com.controledeveiculos.exception.FailedToDeleteVehicleException;
import br.com.controledeveiculos.service.ArchiveService;
import br.com.controledeveiculos.service.UserService;
import br.com.controledeveiculos.service.VehicleService;
import br.com.controledeveiculos.view.template.LargeView;

public class VehicleSoldListScreen extends LargeView {
	
	private static final long serialVersionUID = 5396333298175805263L;
	
	private ArchiveService archiveService;
	private VehicleService vehicleService;
	private List<Vehicle> vehicles;
	
	private DefaultTableModel vehicleTableModel;
	private JTable vehiclesTable;
	private JTextField plateFilterText;
	private JButton filter;
	
	public VehicleSoldListScreen() {
		this.setTitle(this.getTitle() + "Lista de veículos vendidos");
		this.setVisible(true);
		filter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(vehicleTableModel);
				trs.setRowFilter(RowFilter.regexFilter("(?i)" + plateFilterText.getText().trim(), 3));
				vehiclesTable.setRowSorter(trs);
			}
			
		});
	}

	@Override
	public void addLabels() {
		JLabel userLoggedMessage = new JLabel();
		userLoggedMessage.setText("Olá, " + UserService.USER_LOGGED.getName());
		userLoggedMessage.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		userLoggedMessage.setForeground(Color.BLACK);
		userLoggedMessage.setVisible(true);
		userLoggedMessage.setBounds(20, 18, 200, 18);
		this.add(userLoggedMessage);
		
		JLabel plateLabel = new JLabel();
		plateLabel.setText("Placa:");
		plateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		plateLabel.setForeground(Color.BLACK);
		plateLabel.setVisible(true);
		plateLabel.setBounds(40, 65, 200, 18);
		this.add(plateLabel);
	}

	@Override
	public void addButtons() { 
		archiveService = new ArchiveService();
		
		JButton edit = new JButton();
		edit.setText("Editar veículo");
		edit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		edit.setOpaque(true);
		edit.setBackground(Color.BLACK);
		edit.setForeground(Color.BLACK);
		edit.setBounds(55, 600, 150, 30);
		edit.addActionListener(new ActionListener() {
			
			private int getVehicleId() {
				int selectedRow = vehiclesTable.getSelectedRow();
				int modelRow = vehiclesTable.convertRowIndexToModel(selectedRow);
				Vector<Vector<Object>> dataVector = vehicleTableModel.getDataVector();
				Vector<Object> rowDataVector = dataVector.elementAt(modelRow);
				Object[] rowData = rowDataVector.toArray(new Object[rowDataVector.size()]);
				int vehicleId = (int) rowData[0];
				return vehicleId;
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vehiclesTable.getSelectedRow() >= 0) {
					new EditSoldVehicleScreen(getVehicleId());
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum veículo está selecionado.");
				}
			}
			
		});
		this.add(edit);
		
		JButton delete = new JButton();
		delete.setText("Excluir");
		delete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		delete.setOpaque(true);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.BLACK);
		delete.setBounds(235, 600, 150, 30);
		delete.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vehiclesTable.getSelectedRow() >= 0) {
					String vehicleDescription = getVehicleDescription();
					int confirmDialogResponse = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o veículo '" + vehicleDescription + "'?", "Excluir veículo", 0);
					if (confirmDialogResponse == 0) {
						deleteVehicleFromDatabase();
						deleteVehicleFromTable();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum veículo está selecionado.");
				}
			}
			
			private int getVehicleId() {
				int selectedRow = vehiclesTable.getSelectedRow();
				int modelRow = vehiclesTable.convertRowIndexToModel(selectedRow);
				Vector<Vector<Object>> dataVector = vehicleTableModel.getDataVector();
				Vector<Object> rowDataVector = dataVector.elementAt(modelRow);
				Object[] rowData = rowDataVector.toArray(new Object[rowDataVector.size()]);
				int vehicleId = (int) rowData[0];
				return vehicleId;
			}
			
			private String getVehicleDescription() {
				int selectedRow = vehiclesTable.getSelectedRow();
				int modelRow = vehiclesTable.convertRowIndexToModel(selectedRow);
				Vector<Vector<Object>> dataVector = vehicleTableModel.getDataVector();
				Vector<Object> rowDataVector = dataVector.elementAt(modelRow);
				Object[] rowData = rowDataVector.toArray(new Object[rowDataVector.size()]);
				String description = (String) rowData[2];
				return description;
			}
			
			private void deleteVehicleFromDatabase() {
				int vehicleId = getVehicleId();
				try {
					archiveService.deleteFileIfExist(vehicleId);
					vehicleService.delete(vehicleId);
				} catch (FailedToDeleteVehicleException | FailedToDeleteFileException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
				}
			}
			
			private void deleteVehicleFromTable() {
				vehicleTableModel.removeRow(vehiclesTable.convertRowIndexToModel(vehiclesTable.getSelectedRow()));
			}
			
		});
		this.add(delete);
		
		JButton viewFiles = new JButton();
		viewFiles.setText("Ver arquivos");
		viewFiles.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewFiles.setOpaque(true);
		viewFiles.setBackground(Color.BLACK);
		viewFiles.setForeground(Color.BLACK);
		viewFiles.setBounds(415, 600, 150, 30);
		viewFiles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vehiclesTable.getSelectedRow() >= 0) {
					int vehicleId = getVehicleId();
					List<Archive> archives = archiveService.searchByVehicleId(vehicleId);
					if (!archives.isEmpty()) {
						archiveService.openFiles(archives);
					} else {
						JOptionPane.showMessageDialog(null, "O veículo selecionado não possui nenhum arquivo.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum veículo está selecionado.");
				}
			}
			
			private int getVehicleId() {
				int selectedRow = vehiclesTable.getSelectedRow();
				int modelRow = vehiclesTable.convertRowIndexToModel(selectedRow);
				Vector<Vector<Object>> dataVector = vehicleTableModel.getDataVector();
				Vector<Object> rowDataVector = dataVector.elementAt(modelRow);
				Object[] rowData = rowDataVector.toArray(new Object[rowDataVector.size()]);
				int vehicleId = (int) rowData[0];
				return vehicleId;
			}
			
		});
		this.add(viewFiles);
		
		JButton editSale = new JButton();
		editSale.setText("Editar venda");
		editSale.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		editSale.setOpaque(true);
		editSale.setBackground(Color.BLACK);
		editSale.setForeground(Color.BLACK);
		editSale.setBounds(595, 600, 150, 30);
		editSale.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vehiclesTable.getSelectedRow() >= 0) {
					int vehicleId = getVehicleId();
					new EditSaleScreen(vehicleId);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum veículo está selecionado.");
				}
			}
			
			private int getVehicleId() {
				int selectedRow = vehiclesTable.getSelectedRow();
				int modelRow = vehiclesTable.convertRowIndexToModel(selectedRow);
				Vector<Vector<Object>> dataVector = vehicleTableModel.getDataVector();
				Vector<Object> rowDataVector = dataVector.elementAt(modelRow);
				Object[] rowData = rowDataVector.toArray(new Object[rowDataVector.size()]);
				int vehicleId = (int) rowData[0];
				return vehicleId;
			}
			
		});
		this.add(editSale);
		
		filter = new JButton();
		filter.setText("Buscar");
		filter.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		filter.setOpaque(true);
		filter.setBackground(Color.BLACK);
		filter.setForeground(Color.BLACK);
		filter.setBounds(340, 62, 100, 24);
		this.add(filter);
	}

	@Override
	public void addTextFields() {
		plateFilterText = new JTextField();
		plateFilterText.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		plateFilterText.setBounds(80, 62, 250, 24);
		this.add(plateFilterText);
	}

	@Override
	public void addTables() {
		this.vehicleService = new VehicleService();
		this.vehicles = this.vehicleService.listOfVehiclesSold();
		vehicleTableModel = new DefaultTableModel() {

			private static final long serialVersionUID = 8972832026170338243L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};
		
		vehiclesTable = new JTable(vehicleTableModel);
		vehiclesTable.getTableHeader().setReorderingAllowed(false);
		vehiclesTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		String[] vehicleColumns = {"ID", "TIPO", "DESCRIÇÃO", "PLACA", "CHASSI", "RENAVAM", "COMPRADOR"};
		for(String column: vehicleColumns) {
			vehicleTableModel.addColumn(column);
		}
		for(Vehicle vehicle: vehicles) {
			Object[] data = {vehicle.getId(), vehicle.getType(), vehicle.getDescription(), vehicle.getPlate(), vehicle.getChassis(), 
					vehicle.getRenavam(), vehicle.getOutName()};
			vehicleTableModel.addRow(data);
		}
		JScrollPane vehicleContainer = new JScrollPane(vehiclesTable);
		vehicleContainer.setBounds(20, 90, 755, 490);
		add(vehicleContainer);
	}

	@Override
	public void addMenu() {
		this.setJMenuBar(new MenuBar(this));
	}

	@Override
	public void addPanel() { }

}