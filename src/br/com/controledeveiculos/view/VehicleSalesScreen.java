package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.controledeveiculos.components.MenuBar;
import br.com.controledeveiculos.entity.Vehicle;
import br.com.controledeveiculos.exception.VehicleNotFoundException;
import br.com.controledeveiculos.service.VehicleService;
import br.com.controledeveiculos.view.template.LargeView;

public class VehicleSalesScreen extends LargeView {

	private static final long serialVersionUID = -1925226715071719816L;
	
	/*used only read*/
	private JTextField descriptionField;
	private JTextField plateField;
	private JTextField priceField;
	private JTextField renavamField;
	
	private JTextField buyerNameField;
	private JTextField buyerAddressField;
	private JTextField buyerPhoneField;
	private JTextField buyerCpfField;
	private JTextField buyerRgField;
	private JTextField buyerPaymentDescriptionField;
	
	private Vehicle vehicle;
	private VehicleService service;
	
	public VehicleSalesScreen(int vehicleId) {
		this.setTitle(this.getTitle() + "Vender veículo");
		this.setVisible(true);
		this.service = new VehicleService();
		try {
			this.vehicle = this.service.searchById(vehicleId);
			this.populateData();
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
		vehicleLabel.setBounds(330, 18, 200, 18);
		this.add(vehicleLabel);
		
		JLabel descriptionLabel = new JLabel();
		descriptionLabel.setText("Descrição");
		descriptionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		descriptionLabel.setForeground(Color.BLACK);
		descriptionLabel.setVisible(true);
		descriptionLabel.setBounds(25, 60, 60, 16);
		this.add(descriptionLabel);
		
		JLabel plateLabel = new JLabel();
		plateLabel.setText("Placa");
		plateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		plateLabel.setForeground(Color.BLACK);
		plateLabel.setVisible(true);
		plateLabel.setBounds(25, 112, 60, 16);
		this.add(plateLabel);
		
		JLabel priceLabel = new JLabel();
		priceLabel.setText("Preço");
		priceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		priceLabel.setForeground(Color.BLACK);
		priceLabel.setVisible(true);
		priceLabel.setBounds(430, 60, 100, 16);
		this.add(priceLabel);
		
		JLabel observationLabel = new JLabel();
		observationLabel.setText("Renavam");
		observationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		observationLabel.setForeground(Color.BLACK);
		observationLabel.setVisible(true);
		observationLabel.setBounds(430, 112, 100, 16);
		this.add(observationLabel);
		
		JLabel buyerLabel = new JLabel();
		buyerLabel.setText("Dados do comprador");
		buyerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		buyerLabel.setForeground(Color.BLACK);
		buyerLabel.setVisible(true);
		buyerLabel.setBounds(330, 214, 200, 18);
		this.add(buyerLabel);
		
		JLabel buyerNameLabel = new JLabel();
		buyerNameLabel.setText("Nome *");
		buyerNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		buyerNameLabel.setForeground(Color.BLACK);
		buyerNameLabel.setVisible(true);
		buyerNameLabel.setBounds(25, 256, 100, 16);
		this.add(buyerNameLabel);
		
		JLabel buyerAddressLabel = new JLabel();
		buyerAddressLabel.setText("Endereço *");
		buyerAddressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		buyerAddressLabel.setForeground(Color.BLACK);
		buyerAddressLabel.setVisible(true);
		buyerAddressLabel.setBounds(25, 308, 100, 16);
		this.add(buyerAddressLabel);
		
		JLabel buyerPaymentDescriptionLabel = new JLabel();
		buyerPaymentDescriptionLabel.setText("Descrição do pagamento *");
		buyerPaymentDescriptionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		buyerPaymentDescriptionLabel.setForeground(Color.BLACK);
		buyerPaymentDescriptionLabel.setVisible(true);
		buyerPaymentDescriptionLabel.setBounds(25, 360, 150, 16);
		this.add(buyerPaymentDescriptionLabel);
		
		JLabel buyerPhoneLabel = new JLabel();
		buyerPhoneLabel.setText("Telefone de contato *");
		buyerPhoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		buyerPhoneLabel.setForeground(Color.BLACK);
		buyerPhoneLabel.setVisible(true);
		buyerPhoneLabel.setBounds(430, 256, 150, 16);
		this.add(buyerPhoneLabel);
		
		JLabel buyerCpfLabel = new JLabel();
		buyerCpfLabel.setText("CPF");
		buyerCpfLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		buyerCpfLabel.setForeground(Color.BLACK);
		buyerCpfLabel.setVisible(true);
		buyerCpfLabel.setBounds(430, 308, 150, 16);
		this.add(buyerCpfLabel);
		
		JLabel buyerRgLabel = new JLabel();
		buyerRgLabel.setText("RG");
		buyerRgLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		buyerRgLabel.setForeground(Color.BLACK);
		buyerRgLabel.setVisible(true);
		buyerRgLabel.setBounds(430, 360, 150, 16);
		this.add(buyerRgLabel);
	}

	@Override
	public void addButtons() { }

	@Override
	public void addTextFields() { 
		descriptionField = new JTextField();
		descriptionField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		descriptionField.setBounds(20, 80, 368, 24);
		descriptionField.setEnabled(false);
		this.add(descriptionField);
		
		plateField = new JTextField();
		plateField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		plateField.setBounds(20, 132, 368, 24);
		plateField.setEnabled(false);
		this.add(plateField);
		
		priceField = new JTextField();
		priceField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		priceField.setBounds(425, 80, 348, 24);
		priceField.setEnabled(false);
		this.add(priceField);
		
		renavamField = new JTextField();
		renavamField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		renavamField.setBounds(425, 132, 348, 24);
		renavamField.setEnabled(false);
		this.add(renavamField);
		
		buyerNameField = new JTextField();
		buyerNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buyerNameField.setBounds(20, 276, 368, 24);
		this.add(buyerNameField);
		
		buyerAddressField = new JTextField();
		buyerAddressField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buyerAddressField.setBounds(20, 328, 368, 24);
		this.add(buyerAddressField);
		
		buyerPaymentDescriptionField = new JTextField();
		buyerPaymentDescriptionField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buyerPaymentDescriptionField.setBounds(20, 380, 368, 24);
		this.add(buyerPaymentDescriptionField);
		
		buyerPhoneField = new JTextField();
		buyerPhoneField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buyerPhoneField.setBounds(425, 276, 348, 24);
		this.add(buyerPhoneField);
		
		buyerCpfField = new JTextField();
		buyerCpfField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buyerCpfField.setBounds(425, 328, 348, 24);
		this.add(buyerCpfField);
		
		buyerRgField = new JTextField();
		buyerRgField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buyerRgField.setBounds(425, 380, 348, 24);
		this.add(buyerRgField);
	}

	@Override
	public void addTables() { }

	@Override
	public void addMenu() {
		this.setJMenuBar(new MenuBar(this));
	}

	@Override
	public void addPanel() {
		JPanel vehiclePanel = new JPanel();
		vehiclePanel.setBounds(20, 194, 755, 1);
		vehiclePanel.setBackground(Color.GRAY);
		this.add(vehiclePanel);
	}
	
	private void populateData() {
		this.descriptionField.setText(this.vehicle.getDescription());
		this.plateField.setText(this.vehicle.getPlate());
		this.renavamField.setText(this.vehicle.getRenavam());
		this.priceField.setText(this.vehicle.getSalePrice());
	}

}