package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.controledeveiculos.actions.RegisterVehicleAction;
import br.com.controledeveiculos.components.MenuBar;
import br.com.controledeveiculos.view.template.LargeView;

public class RegisterVehicleScreen extends LargeView {

	private static final long serialVersionUID = 4158150115991758842L;
	
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
	private JFileChooser vehicleFirstFileChooser;
	private JFileChooser vehicleSecondFileChooser;
	private JLabel vehicleFirstFileChooserLabel;
	private JLabel vehicleSecondFileChooserLabel;
	
	public RegisterVehicleScreen() {
		this.setTitle(this.getTitle() + "Cadastrar veiculo");
		this.setVisible(true);
		this.addFileChooser();
	}

	@Override
	public void addLabels() {
		JLabel vehicleLabel = new JLabel();
		vehicleLabel.setText("Dados do veiculo");
		vehicleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		vehicleLabel.setForeground(Color.BLACK);
		vehicleLabel.setVisible(true);
		vehicleLabel.setBounds(335, 18, 200, 18);
		this.add(vehicleLabel);
		
		JLabel descriptionLabel = new JLabel();
		descriptionLabel.setText("Descricao *");
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
		vehicleType.setText("Tipo de veiculo *");
		vehicleType.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		vehicleType.setForeground(Color.BLACK);
		vehicleType.setVisible(true);
		vehicleType.setBounds(25, 268, 100, 16);
		this.add(vehicleType);
		
		JLabel priceLabel = new JLabel();
		priceLabel.setText("Preco *");
		priceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		priceLabel.setForeground(Color.BLACK);
		priceLabel.setVisible(true);
		priceLabel.setBounds(430, 60, 100, 16);
		this.add(priceLabel);
		
		JLabel observationLabel = new JLabel();
		observationLabel.setText("Observacoes");
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
		sellerLabel.setBounds(335, 450, 200, 18);
		this.add(sellerLabel);
		
		JLabel sellerNameLabel = new JLabel();
		sellerNameLabel.setText("Nome *");
		sellerNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerNameLabel.setForeground(Color.BLACK);
		sellerNameLabel.setVisible(true);
		sellerNameLabel.setBounds(25, 492, 100, 16);
		this.add(sellerNameLabel);
		
		JLabel sellerAddressLabel = new JLabel();
		sellerAddressLabel.setText("Endereco *");
		sellerAddressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerAddressLabel.setForeground(Color.BLACK);
		sellerAddressLabel.setVisible(true);
		sellerAddressLabel.setBounds(25, 544, 100, 16);
		this.add(sellerAddressLabel);
		
		JLabel sellerPaymentDescriptionLabel = new JLabel();
		sellerPaymentDescriptionLabel.setText("Descricao do pagamento *");
		sellerPaymentDescriptionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerPaymentDescriptionLabel.setForeground(Color.BLACK);
		sellerPaymentDescriptionLabel.setVisible(true);
		sellerPaymentDescriptionLabel.setBounds(25, 596, 150, 16);
		this.add(sellerPaymentDescriptionLabel);
		
		JLabel sellerPhoneLabel = new JLabel();
		sellerPhoneLabel.setText("Telefone de contato *");
		sellerPhoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerPhoneLabel.setForeground(Color.BLACK);
		sellerPhoneLabel.setVisible(true);
		sellerPhoneLabel.setBounds(430, 492, 150, 16);
		this.add(sellerPhoneLabel);
		
		JLabel sellerCpfLabel = new JLabel();
		sellerCpfLabel.setText("CPF");
		sellerCpfLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerCpfLabel.setForeground(Color.BLACK);
		sellerCpfLabel.setVisible(true);
		sellerCpfLabel.setBounds(430, 544, 150, 16);
		this.add(sellerCpfLabel);
		
		JLabel sellerRgLabel = new JLabel();
		sellerRgLabel.setText("RG");
		sellerRgLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sellerRgLabel.setForeground(Color.BLACK);
		sellerRgLabel.setVisible(true);
		sellerRgLabel.setBounds(430, 596, 150, 16);
		this.add(sellerRgLabel);

		vehicleFirstFileChooserLabel = new JLabel();
		vehicleFirstFileChooserLabel.setText("Nenhum arquivo selecionado...");
		vehicleFirstFileChooserLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		vehicleFirstFileChooserLabel.setForeground(Color.BLACK);
		vehicleFirstFileChooserLabel.setVisible(true);
		vehicleFirstFileChooserLabel.setBounds(240, 337, 150, 16);
		this.add(vehicleFirstFileChooserLabel);

		vehicleSecondFileChooserLabel = new JLabel();
		vehicleSecondFileChooserLabel.setText("Nenhum arquivo selecionado...");
		vehicleSecondFileChooserLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		vehicleSecondFileChooserLabel.setForeground(Color.BLACK);
		vehicleSecondFileChooserLabel.setVisible(true);
		vehicleSecondFileChooserLabel.setBounds(240, 387, 150, 16);
		this.add(vehicleSecondFileChooserLabel);
	}

	@Override
	public void addButtons() {
		JButton uploadFirstFile = new JButton();
		uploadFirstFile.setText("Subir arquivo 1");
		uploadFirstFile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		uploadFirstFile.setOpaque(true);
		uploadFirstFile.setBackground(Color.BLACK);
		uploadFirstFile.setForeground(Color.BLACK);
		uploadFirstFile.setBounds(20, 330, 200, 30);
		uploadFirstFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int response = vehicleFirstFileChooser.showOpenDialog(null);

				if (JFileChooser.APPROVE_OPTION == response) {
					File file = vehicleFirstFileChooser.getSelectedFile();
					vehicleFirstFileChooserLabel.setText(file.getName());
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
				if (vehicleFirstFileChooser.getSelectedFile() != null) {
					vehicleFirstFileChooser.setSelectedFile(null);
					vehicleFirstFileChooserLabel.setText("Nenhum arquivo selecionado...");
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado.");
				}
			}

		});
		deleteFirstFile.setBounds(570, 330, 200, 30);

		this.add(deleteFirstFile);

		JButton uploadSecondFile = new JButton();
		uploadSecondFile.setText("Subir arquivo 2");
		uploadSecondFile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		uploadSecondFile.setOpaque(true);
		uploadSecondFile.setBackground(Color.BLACK);
		uploadSecondFile.setForeground(Color.BLACK);
		uploadSecondFile.setBounds(20, 380, 200, 30);
		uploadSecondFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int response = vehicleSecondFileChooser.showOpenDialog(null);

				if (JFileChooser.APPROVE_OPTION == response) {
					File file = vehicleSecondFileChooser.getSelectedFile();
					vehicleSecondFileChooserLabel.setText(file.getName());
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
		deleteSecondFile.setBounds(570, 380, 200, 30);
		deleteSecondFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (vehicleSecondFileChooser.getSelectedFile() != null) {
					vehicleSecondFileChooser.setSelectedFile(null);
					vehicleSecondFileChooserLabel.setText("Nenhum arquivo selecionado...");
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado.");
				}
			}

		});
		this.add(deleteSecondFile);

		JButton register = new JButton();
		register.setText("Cadastrar");
		register.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		register.setOpaque(true);
		register.setBackground(Color.BLACK);
		register.setForeground(Color.BLACK);
		register.setBounds(290, 670, 200, 30);
		register.addActionListener(new RegisterVehicleAction(this));
		this.add(register);
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
		sellerNameField.setBounds(20, 512, 368, 24);
		this.add(sellerNameField);
		
		sellerAddressField = new JTextField();
		sellerAddressField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sellerAddressField.setBounds(20, 564, 368, 24);
		this.add(sellerAddressField);
		
		sellerPaymentDescriptionField = new JTextField();
		sellerPaymentDescriptionField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sellerPaymentDescriptionField.setBounds(20, 616, 368, 24);
		this.add(sellerPaymentDescriptionField);
		
		sellerPhoneField = new JTextField();
		sellerPhoneField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sellerPhoneField.setBounds(425, 512, 348, 24);
		this.add(sellerPhoneField);
		
		sellerCpfField = new JTextField();
		sellerCpfField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sellerCpfField.setBounds(425, 564, 348, 24);
		this.add(sellerCpfField);
		
		sellerRgField = new JTextField();
		sellerRgField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sellerRgField.setBounds(425, 616, 348, 24);
		this.add(sellerRgField);
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
		JPanel sellerPanel = new JPanel();
		sellerPanel.setBounds(20, 430, 755, 1);
		sellerPanel.setBackground(Color.GRAY);
		this.add(sellerPanel);
	}

	private void addFileChooser() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF, PNG, JPG, JPEG, DOCX, TXT", "pdf", "png", "jpg", "jpeg", "docx", "txt");

		vehicleFirstFileChooser = new JFileChooser();
		vehicleFirstFileChooser.setAcceptAllFileFilterUsed(false);
		vehicleFirstFileChooser.addChoosableFileFilter(filter);

		vehicleSecondFileChooser = new JFileChooser();
		vehicleSecondFileChooser.setAcceptAllFileFilterUsed(false);
		vehicleSecondFileChooser.addChoosableFileFilter(filter);
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

	public JFileChooser getVehicleFirstFileChooser() {
		return vehicleFirstFileChooser;
	}

	public JFileChooser getVehicleSecondFileChooser() {
		return vehicleSecondFileChooser;
	}
}