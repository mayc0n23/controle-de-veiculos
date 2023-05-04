package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	
	public VehicleSoldListScreen() {
		this.setTitle(this.getTitle() + "Lista de veículos vendidos");
		this.setVisible(true);
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
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vehiclesTable.getSelectedRow() >= 0) {
					int vehicleId = (int) vehicleTableModel.getValueAt(vehiclesTable.getSelectedRow(), 0);
					new EditSoldVehicleScreen(vehicleId);
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
					String vehicleDescription = (String) vehicleTableModel.getValueAt(vehiclesTable.getSelectedRow(), 2);
					int confirmDialogResponse = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o veículo '" + vehicleDescription + "'?", "Excluir veículo", 0);
					if (confirmDialogResponse == 0) {
						deleteVehicleFromDatabase();
						deleteVehicleFromTable();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum veículo está selecionado.");
				}
			}
			
			private void deleteVehicleFromDatabase() {
				int vehicleId = (int) vehicleTableModel.getValueAt(vehiclesTable.getSelectedRow(), 0);
				try {
					archiveService.deleteFileIfExist(vehicleId);
					vehicleService.delete(vehicleId);
				} catch (FailedToDeleteVehicleException | FailedToDeleteFileException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
				}
			}
			
			private void deleteVehicleFromTable() {
				vehicleTableModel.removeRow(vehiclesTable.getSelectedRow());
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
					int vehicleId = (int) vehicleTableModel.getValueAt(vehiclesTable.getSelectedRow(), 0);
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
					int vehicleId = (int) vehicleTableModel.getValueAt(vehiclesTable.getSelectedRow(), 0);
					new EditSaleScreen(vehicleId);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum veículo está selecionado.");
				}
			}
			
		});
		this.add(editSale);
	}

	@Override
	public void addTextFields() { }

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
		vehicleContainer.setBounds(20, 60, 755, 520);
		add(vehicleContainer);
	}

	@Override
	public void addMenu() {
		this.setJMenuBar(new MenuBar(this));
	}

	@Override
	public void addPanel() { }

}