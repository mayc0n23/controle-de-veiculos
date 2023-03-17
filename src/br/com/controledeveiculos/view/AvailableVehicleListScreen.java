package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.controledeveiculos.components.MenuBar;
import br.com.controledeveiculos.service.UserService;
import br.com.controledeveiculos.view.template.LargeView;

public class AvailableVehicleListScreen extends LargeView {

	private static final long serialVersionUID = -741211066483646413L;
	
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
		userLoggedMessage.setBounds(600, 12, 200, 18);
		this.add(userLoggedMessage);
	}

	@Override
	public void addButtons() { }

	@Override
	public void addTextFields() { }

	@Override
	public void addTables() {
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
		
		String[] vehicleColumns = {"ID", "DESCRIÇÃO", "PLACA", "CHASSI", "RENAVAM", "VALOR"};
		for(String column: vehicleColumns) {
			vehicleTableModel.addColumn(column);
		}
		for(int index = 0; index < 10; index++) {
			Object[] data = {index, "Bros 160", "PEQ6A21", "W4F1DS6541G654GN", 586456464, 12000};
			vehicleTableModel.addRow(data);
		}
		JScrollPane vehicleContainer = new JScrollPane(vehiclesTable);
		vehicleContainer.setBounds(20, 60, 760, 550);
		add(vehicleContainer);
	}

	@Override
	public void addMenu() {
		this.setJMenuBar(new MenuBar(this));
	}

}