package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.controledeveiculos.components.MenuBar;
import br.com.controledeveiculos.entity.Vehicle;
import br.com.controledeveiculos.exception.VehicleNotFoundException;
import br.com.controledeveiculos.service.VehicleService;
import br.com.controledeveiculos.view.template.LargeView;

public class EditSoldVehicleScreen extends LargeView {

	private static final long serialVersionUID = 2066861241371424311L;
	
	private JTextField descriptionField;
	private JTextField plateField;
	private JTextField chassiField;
	private JTextField renavamField;
	private JComboBox<String> vehicleTypeField;
	private JTextField priceField;
	private JTextArea observationField;
	private JTextField sellerNameField;
	private JTextField sellerAddressField;
	private JTextField sellerPhoneField;
	private JTextField sellerCpfField;
	private JTextField sellerRgField;
	private JTextField sellerPaymentDescriptionField;
	
	private JButton save;
	
	private Vehicle vehicle;
	private VehicleService service;
	
	public EditSoldVehicleScreen(int vehicleId) {
		this.setTitle(this.getTitle() + "Editar veículo");
		this.setVisible(true);
		this.service = new VehicleService();
		try {
			this.vehicle = this.service.searchById(vehicleId);
			this.populateVehicleData();
			//this.addActionButton();
		} catch (VehicleNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao tentar encontrar o veículo! Tente novamente.");
			new AvailableVehicleListScreen();
			dispose();
		}
	}

	@Override
	public void addLabels() {
		JLabel vehicleLabel = new JLabel();
		vehicleLabel.setText("Dados do veículo");
		vehicleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		vehicleLabel.setForeground(Color.BLACK);
		vehicleLabel.setVisible(true);
		vehicleLabel.setBounds(335, 18, 200, 18);
		this.add(vehicleLabel);
		
		JLabel descriptionLabel = new JLabel();
		descriptionLabel.setText("Descrição *");
		descriptionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		descriptionLabel.setForeground(Color.BLACK);
		descriptionLabel.setVisible(true);
		descriptionLabel.setBounds(25, 60, 60, 16);
		this.add(descriptionLabel);
		
		JLabel plateLabel = new JLabel();
		plateLabel.setText("Placa *");
		plateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		plateLabel.setForeground(Color.BLACK);
		plateLabel.setVisible(true);
		plateLabel.setBounds(25, 112, 60, 16);
		this.add(plateLabel);
		
		JLabel chassiLabel = new JLabel();
		chassiLabel.setText("Chassi");
		chassiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chassiLabel.setForeground(Color.BLACK);
		chassiLabel.setVisible(true);
		chassiLabel.setBounds(25, 164, 60, 16);
		this.add(chassiLabel);
		
		JLabel renavamLabel = new JLabel();
		renavamLabel.setText("Renavam");
		renavamLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		renavamLabel.setForeground(Color.BLACK);
		renavamLabel.setVisible(true);
		renavamLabel.setBounds(25, 216, 60, 16);
		this.add(renavamLabel);
		
		JLabel vehicleType = new JLabel();
		vehicleType.setText("Tipo de veículo *");
		vehicleType.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		vehicleType.setForeground(Color.BLACK);
		vehicleType.setVisible(true);
		vehicleType.setBounds(25, 268, 100, 16);
		this.add(vehicleType);
		
		JLabel priceLabel = new JLabel();
		priceLabel.setText("Preço *");
		priceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		priceLabel.setForeground(Color.BLACK);
		priceLabel.setVisible(true);
		priceLabel.setBounds(430, 60, 100, 16);
		this.add(priceLabel);
		
		JLabel observationLabel = new JLabel();
		observationLabel.setText("Observações");
		observationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		observationLabel.setForeground(Color.BLACK);
		observationLabel.setVisible(true);
		observationLabel.setBounds(430, 112, 100, 16);
		this.add(observationLabel);
		
		JLabel sellerLabel = new JLabel();
		sellerLabel.setText("Dados do vendedor");
		sellerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		sellerLabel.setForeground(Color.BLACK);
		sellerLabel.setVisible(true);
		sellerLabel.setBounds(335, 370, 200, 18);
		this.add(sellerLabel);
		
		JLabel sellerNameLabel = new JLabel();
		sellerNameLabel.setText("Nome *");
		sellerNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerNameLabel.setForeground(Color.BLACK);
		sellerNameLabel.setVisible(true);
		sellerNameLabel.setBounds(25, 412, 100, 16);
		this.add(sellerNameLabel);
		
		JLabel sellerAddressLabel = new JLabel();
		sellerAddressLabel.setText("Endereço *");
		sellerAddressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerAddressLabel.setForeground(Color.BLACK);
		sellerAddressLabel.setVisible(true);
		sellerAddressLabel.setBounds(25, 464, 100, 16);
		this.add(sellerAddressLabel);
		
		JLabel sellerPaymentDescriptionLabel = new JLabel();
		sellerPaymentDescriptionLabel.setText("Descrição do pagamento *");
		sellerPaymentDescriptionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerPaymentDescriptionLabel.setForeground(Color.BLACK);
		sellerPaymentDescriptionLabel.setVisible(true);
		sellerPaymentDescriptionLabel.setBounds(25, 516, 150, 16);
		this.add(sellerPaymentDescriptionLabel);
		
		JLabel sellerPhoneLabel = new JLabel();
		sellerPhoneLabel.setText("Telefone de contato *");
		sellerPhoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerPhoneLabel.setForeground(Color.BLACK);
		sellerPhoneLabel.setVisible(true);
		sellerPhoneLabel.setBounds(430, 412, 150, 16);
		this.add(sellerPhoneLabel);
		
		JLabel sellerCpfLabel = new JLabel();
		sellerCpfLabel.setText("CPF");
		sellerCpfLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerCpfLabel.setForeground(Color.BLACK);
		sellerCpfLabel.setVisible(true);
		sellerCpfLabel.setBounds(430, 464, 150, 16);
		this.add(sellerCpfLabel);
		
		JLabel sellerRgLabel = new JLabel();
		sellerRgLabel.setText("RG");
		sellerRgLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerRgLabel.setForeground(Color.BLACK);
		sellerRgLabel.setVisible(true);
		sellerRgLabel.setBounds(430, 516, 150, 16);
		this.add(sellerRgLabel);
	}

	@Override
	public void addButtons() {
		save = new JButton();
		save.setText("Salvar");
		save.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		save.setOpaque(true);
		save.setBackground(Color.BLACK);
		save.setForeground(Color.BLACK);
		save.setBounds(290, 590, 200, 30);
		this.add(save);
	}

	@Override
	public void addTextFields() {
		descriptionField = new JTextField();
		descriptionField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		descriptionField.setBounds(20, 80, 368, 24);
		this.add(descriptionField);
		
		plateField = new JTextField();
		plateField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		plateField.setBounds(20, 132, 368, 24);
		this.add(plateField);
		
		chassiField = new JTextField();
		chassiField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		chassiField.setBounds(20, 184, 368, 24);
		this.add(chassiField);
		
		renavamField = new JTextField();
		renavamField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		renavamField.setBounds(20, 236, 368, 24);
		this.add(renavamField);
		
		String[] vehicleTypeList = {"MOTO", "CARRO", "OUTROS"};
		vehicleTypeField = new JComboBox<>(vehicleTypeList);
		vehicleTypeField.setBounds(20, 288, 368, 24);
		vehicleTypeField.setBackground(Color.WHITE);
		this.add(vehicleTypeField);
		
		priceField = new JTextField();
		priceField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		priceField.setBounds(425, 80, 348, 24);
		this.add(priceField);
		
		observationField = new JTextArea();
		observationField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		observationField.setBounds(425, 132, 348, 180);
		observationField.setLineWrap(true);
		this.add(observationField);
		
		sellerNameField = new JTextField();
		sellerNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sellerNameField.setBounds(20, 432, 368, 24);
		this.add(sellerNameField);
		
		sellerAddressField = new JTextField();
		sellerAddressField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sellerAddressField.setBounds(20, 484, 368, 24);
		this.add(sellerAddressField);
		
		sellerPaymentDescriptionField = new JTextField();
		sellerPaymentDescriptionField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sellerPaymentDescriptionField.setBounds(20, 536, 368, 24);
		this.add(sellerPaymentDescriptionField);
		
		sellerPhoneField = new JTextField();
		sellerPhoneField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sellerPhoneField.setBounds(425, 432, 348, 24);
		this.add(sellerPhoneField);
		
		sellerCpfField = new JTextField();
		sellerCpfField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sellerCpfField.setBounds(425, 484, 348, 24);
		this.add(sellerCpfField);
		
		sellerRgField = new JTextField();
		sellerRgField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sellerRgField.setBounds(425, 536, 348, 24);
		this.add(sellerRgField);
	}

	@Override
	public void addTables() { }

	@Override
	public void addMenu() {
		this.setJMenuBar(new MenuBar(this));
	}

	@Override
	public void addPanel() {
		JPanel sellerPanel = new JPanel();
		sellerPanel.setBounds(20, 350, 755, 1);
		sellerPanel.setBackground(Color.GRAY);
		this.add(sellerPanel);
	}

	public JTextField getDescriptionField() {
		return descriptionField;
	}

	public JTextField getPlateField() {
		return plateField;
	}

	public JTextField getChassiField() {
		return chassiField;
	}

	public JTextField getRenavamField() {
		return renavamField;
	}

	public JComboBox<String> getVehicleTypeField() {
		return vehicleTypeField;
	}

	public JTextField getPriceField() {
		return priceField;
	}

	public JTextArea getObservationField() {
		return observationField;
	}

	public JTextField getSellerNameField() {
		return sellerNameField;
	}

	public JTextField getSellerAddressField() {
		return sellerAddressField;
	}

	public JTextField getSellerPhoneField() {
		return sellerPhoneField;
	}

	public JTextField getSellerCpfField() {
		return sellerCpfField;
	}

	public JTextField getSellerRgField() {
		return sellerRgField;
	}

	public JTextField getSellerPaymentDescriptionField() {
		return sellerPaymentDescriptionField;
	}
	
	private void populateVehicleData() {
		this.descriptionField.setText(this.vehicle.getDescription());
		this.plateField.setText(this.vehicle.getPlate());
		this.chassiField.setText(this.vehicle.getChassis());
		this.renavamField.setText(this.vehicle.getRenavam());
		this.vehicleTypeField.setSelectedItem((String) this.vehicle.getType());
		this.priceField.setText(this.vehicle.getSalePrice());
		this.observationField.setText(this.vehicle.getObservation());
		this.sellerNameField.setText(this.vehicle.getInName());
		this.sellerAddressField.setText(this.vehicle.getInAddress());
		this.sellerPhoneField.setText(this.vehicle.getInPhone());
		this.sellerCpfField.setText(this.vehicle.getInCpf());
		this.sellerRgField.setText(this.vehicle.getInRg());
		this.sellerPaymentDescriptionField.setText(this.vehicle.getInPaymentDescription());
	}
	
}