package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.controledeveiculos.components.MenuBar;
import br.com.controledeveiculos.entity.Vehicle;
import br.com.controledeveiculos.service.UserService;
import br.com.controledeveiculos.service.VehicleService;
import br.com.controledeveiculos.view.template.LargeView;

public class AvailableVehicleListScreen extends LargeView {

	private static final long serialVersionUID = -741211066483646413L;
	
	private VehicleService service;
	private List<Vehicle> vehicles;
	
	private DefaultTableModel vehicleTableModel;
	private JTable vehiclesTable;
	
	public AvailableVehicleListScreen() {
		this.setTitle(this.getTitle() + "Lista de veículos disponíveis");
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
	public void addButtons() { }

	@Override
	public void addTextFields() { }

	@Override
	public void addTables() {
		this.service = new VehicleService();
		this.vehicles = this.service.listOfAvailableVehicles();

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
		vehiclesTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			private static final long serialVersionUID = 3435114482235721602L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				component.setBackground(row % 2 == 0 ? Color.decode("#F0F0F0") : Color.WHITE);
				return component;
			}
			
		});
		
		String[] vehicleColumns = {"ID", "TIPO", "DESCRIÇÃO", "PLACA", "CHASSI", "RENAVAM", "VALOR"};
		for(String column: vehicleColumns) {
			vehicleTableModel.addColumn(column);
		}
		for(Vehicle vehicle: vehicles) {
			Object[] data = {vehicle.getId(), vehicle.getType(), vehicle.getDescription(), vehicle.getPlate(), vehicle.getChassis(), 
					vehicle.getRenavam(), vehicle.getSalePrice()};
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