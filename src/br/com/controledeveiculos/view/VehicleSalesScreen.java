package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.controledeveiculos.actions.SellVehicleAction;
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
	
	private JFileChooser firstFileChooser;
	private JFileChooser secondFileChooser;
	private JFileChooser thirdFileChooser;
	private JButton save;
	
	private JLabel firstFileChooserLabel;
	private JLabel secondFileChooserLabel;
	private JLabel thirdFileChooserLabel;
	
	private Vehicle vehicle;
	private VehicleService service;
	
	public VehicleSalesScreen(int vehicleId) {
		this.setTitle(this.getTitle() + "Vender veículo");
		this.setVisible(true);
		this.service = new VehicleService();
		try {
			this.vehicle = this.service.searchById(vehicleId);
			this.populateData();
			this.addFileChooser();
			save.addActionListener(new SellVehicleAction(this, vehicle));
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
		
		firstFileChooserLabel = new JLabel();
		firstFileChooserLabel.setText("Nenhum arquivo selecionado...");
		firstFileChooserLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		firstFileChooserLabel.setForeground(Color.BLACK);
		firstFileChooserLabel.setVisible(true);
		firstFileChooserLabel.setBounds(240, 437, 150, 16);
		this.add(firstFileChooserLabel);
		
		secondFileChooserLabel = new JLabel();
		secondFileChooserLabel.setText("Nenhum arquivo selecionado...");
		secondFileChooserLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		secondFileChooserLabel.setForeground(Color.BLACK);
		secondFileChooserLabel.setVisible(true);
		secondFileChooserLabel.setBounds(240, 487, 150, 16);
		this.add(secondFileChooserLabel);
		
		thirdFileChooserLabel = new JLabel();
		thirdFileChooserLabel.setText("Nenhum arquivo selecionado...");
		thirdFileChooserLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		thirdFileChooserLabel.setForeground(Color.BLACK);
		thirdFileChooserLabel.setVisible(true);
		thirdFileChooserLabel.setBounds(240, 537, 150, 16);
		this.add(thirdFileChooserLabel);
	}

	@Override
	public void addButtons() {
		JButton uploadFirstFile = new JButton();
		uploadFirstFile.setText("Subir arquivo 1");
		uploadFirstFile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		uploadFirstFile.setOpaque(true);
		uploadFirstFile.setBackground(Color.BLACK);
		uploadFirstFile.setForeground(Color.BLACK);
		uploadFirstFile.setBounds(20, 430, 200, 30);
		uploadFirstFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = firstFileChooser.showOpenDialog(null);
				
				if (JFileChooser.APPROVE_OPTION == response) {
					File file = firstFileChooser.getSelectedFile();
					firstFileChooserLabel.setText(file.getName());
				}
			}
			
		});
		this.add(uploadFirstFile);
		
		JButton deleteFirstFile = new JButton();
		deleteFirstFile.setText("Remover arquivo 1");
		deleteFirstFile.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		deleteFirstFile.setOpaque(true);
		deleteFirstFile.setBackground(Color.BLACK);
		deleteFirstFile.setForeground(Color.RED);
		deleteFirstFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (firstFileChooser.getSelectedFile() != null) {
					firstFileChooser.setSelectedFile(null);
					firstFileChooserLabel.setText("Nenhum arquivo selecionado...");
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado.");
				}
			}
			
		});
		deleteFirstFile.setBounds(570, 430, 200, 30);
		
		this.add(deleteFirstFile);
		
		JButton uploadSecondFile = new JButton();
		uploadSecondFile.setText("Subir arquivo 2");
		uploadSecondFile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		uploadSecondFile.setOpaque(true);
		uploadSecondFile.setBackground(Color.BLACK);
		uploadSecondFile.setForeground(Color.BLACK);
		uploadSecondFile.setBounds(20, 480, 200, 30);
		uploadSecondFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = secondFileChooser.showOpenDialog(null);
				
				if (JFileChooser.APPROVE_OPTION == response) {
					File file = secondFileChooser.getSelectedFile();
					secondFileChooserLabel.setText(file.getName());
				}
			}
			
		});
		this.add(uploadSecondFile);
		
		JButton deleteSecondFile = new JButton();
		deleteSecondFile.setText("Remover arquivo 2");
		deleteSecondFile.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		deleteSecondFile.setOpaque(true);
		deleteSecondFile.setBackground(Color.BLACK);
		deleteSecondFile.setForeground(Color.RED);
		deleteSecondFile.setBounds(570, 480, 200, 30);
		deleteSecondFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (secondFileChooser.getSelectedFile() != null) {
					secondFileChooser.setSelectedFile(null);
					secondFileChooserLabel.setText("Nenhum arquivo selecionado...");
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado.");
				}
			}
			
		});
		this.add(deleteSecondFile);
		
		JButton uploadThirdFile = new JButton();
		uploadThirdFile.setText("Subir arquivo 3");
		uploadThirdFile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		uploadThirdFile.setOpaque(true);
		uploadThirdFile.setBackground(Color.BLACK);
		uploadThirdFile.setForeground(Color.BLACK);
		uploadThirdFile.setBounds(20, 530, 200, 30);
		uploadThirdFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = thirdFileChooser.showOpenDialog(null);
				
				if (JFileChooser.APPROVE_OPTION == response) {
					File file = thirdFileChooser.getSelectedFile();
					thirdFileChooserLabel.setText(file.getName());
				}
			}
			
		});
		this.add(uploadThirdFile);
		
		JButton deleteThirdFile = new JButton();
		deleteThirdFile.setText("Remover arquivo 3");
		deleteThirdFile.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		deleteThirdFile.setOpaque(true);
		deleteThirdFile.setBackground(Color.BLACK);
		deleteThirdFile.setForeground(Color.RED);
		deleteThirdFile.setBounds(570, 530, 200, 30);
		deleteThirdFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (thirdFileChooser.getSelectedFile() != null) {
					thirdFileChooser.setSelectedFile(null);
					thirdFileChooserLabel.setText("Nenhum arquivo selecionado...");
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado.");
				}
			}
			
		});
		this.add(deleteThirdFile);
		
		save = new JButton();
		save.setText("Salvar");
		save.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		save.setOpaque(true);
		save.setBackground(Color.BLACK);
		save.setForeground(Color.BLACK);
		save.setBounds(300, 590, 200, 30);
		save.addActionListener(new SellVehicleAction(this, vehicle));
		this.add(save);
		
	}

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
	
	private void addFileChooser() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF, PNG, JPG, JPEG, DOCX, TXT", "pdf", "png", "jpg", "jpeg", "docx", "txt");
		
		firstFileChooser = new JFileChooser();
		firstFileChooser.setAcceptAllFileFilterUsed(false);
		firstFileChooser.addChoosableFileFilter(filter);
		
		secondFileChooser = new JFileChooser();
		secondFileChooser.setAcceptAllFileFilterUsed(false);
		secondFileChooser.addChoosableFileFilter(filter);
		
		thirdFileChooser = new JFileChooser();
		thirdFileChooser.setAcceptAllFileFilterUsed(false);
		thirdFileChooser.addChoosableFileFilter(filter);
	}
	
	private void populateData() {
		this.descriptionField.setText(this.vehicle.getDescription());
		this.plateField.setText(this.vehicle.getPlate());
		this.renavamField.setText(this.vehicle.getRenavam());
		this.priceField.setText(this.vehicle.getSalePrice());
	}

	public JTextField getBuyerNameField() {
		return buyerNameField;
	}

	public JTextField getBuyerAddressField() {
		return buyerAddressField;
	}

	public JTextField getBuyerPhoneField() {
		return buyerPhoneField;
	}

	public JTextField getBuyerCpfField() {
		return buyerCpfField;
	}

	public JTextField getBuyerRgField() {
		return buyerRgField;
	}

	public JTextField getBuyerPaymentDescriptionField() {
		return buyerPaymentDescriptionField;
	}

	public JFileChooser getFirstFileChooser() {
		return firstFileChooser;
	}

	public JFileChooser getSecondFileChooser() {
		return secondFileChooser;
	}

	public JFileChooser getThirdFileChooser() {
		return thirdFileChooser;
	}

}