package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.controledeveiculos.components.MenuBar;
import br.com.controledeveiculos.service.UserService;
import br.com.controledeveiculos.view.template.LargeView;

public class RegisterVehicleScreen extends LargeView {

	private static final long serialVersionUID = 4158150115991758842L;
	
	private JTextField descriptionField;
	private JTextField plateField;
	private JTextField chassiField;
	private JTextField renavamField;
	private JComboBox<String> vehicleTypeField;
	
	public RegisterVehicleScreen() {
		this.setTitle(this.getTitle() + "Cadastrar veículo");
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
		
		JLabel descriptionLabel = new JLabel();
		descriptionLabel.setText("Descrição *");
		descriptionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		descriptionLabel.setForeground(Color.BLACK);
		descriptionLabel.setVisible(true);
		descriptionLabel.setBounds(25, 80, 60, 16);
		this.add(descriptionLabel);
		
		JLabel plateLabel = new JLabel();
		plateLabel.setText("Placa *");
		plateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		plateLabel.setForeground(Color.BLACK);
		plateLabel.setVisible(true);
		plateLabel.setBounds(25, 132, 60, 16);
		this.add(plateLabel);
		
		JLabel chassiLabel = new JLabel();
		chassiLabel.setText("Chassi *");
		chassiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chassiLabel.setForeground(Color.BLACK);
		chassiLabel.setVisible(true);
		chassiLabel.setBounds(25, 184, 60, 16);
		this.add(chassiLabel);
		
		JLabel renavamLabel = new JLabel();
		renavamLabel.setText("Renavam *");
		renavamLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		renavamLabel.setForeground(Color.BLACK);
		renavamLabel.setVisible(true);
		renavamLabel.setBounds(25, 236, 60, 16);
		this.add(renavamLabel);
		
		JLabel vehicleType = new JLabel();
		vehicleType.setText("Tipo de veículo *");
		vehicleType.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		vehicleType.setForeground(Color.BLACK);
		vehicleType.setVisible(true);
		vehicleType.setBounds(25, 288, 100, 16);
		this.add(vehicleType);
	}

	@Override
	public void addButtons() {
		
	}

	@Override
	public void addTextFields() {
		descriptionField = new JTextField();
		descriptionField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		descriptionField.setBounds(20, 100, 368, 24);
		this.add(descriptionField);
		
		plateField = new JTextField();
		plateField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		plateField.setBounds(20, 152, 368, 24);
		this.add(plateField);
		
		chassiField = new JTextField();
		chassiField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		chassiField.setBounds(20, 204, 368, 24);
		this.add(chassiField);
		
		renavamField = new JTextField();
		renavamField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		renavamField.setBounds(20, 256, 368, 24);
		this.add(renavamField);
		
		String[] vehicleTypeList = {"MOTO", "CARRO", "OUTROS"};
		vehicleTypeField = new JComboBox<>(vehicleTypeList);
		vehicleTypeField.setBounds(20, 308, 368, 24);
		vehicleTypeField.setBackground(Color.WHITE);
		this.add(vehicleTypeField);
	}

	@Override
	public void addTables() {

	}

	@Override
	public void addMenu() {
		this.setJMenuBar(new MenuBar(this));
	}

	@Override
	public void addPanel() {
		JPanel vehiclePanel = new JPanel();
		vehiclePanel.setBounds(20, 60, 755, 1);
		vehiclePanel.setBackground(Color.GRAY);
		this.add(vehiclePanel);
	}

}