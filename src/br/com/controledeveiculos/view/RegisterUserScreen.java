package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.controledeveiculos.actions.RegisterUserAction;

import br.com.controledeveiculos.view.template.LowView;

public class RegisterUserScreen extends LowView {

	private static final long serialVersionUID = -100878298681752445L;
	
	private JTextField nameField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	public RegisterUserScreen() {
		this.setTitle(this.getTitle() + "Cadastrar usuário");
		this.setVisible(true);
	}

	@Override
	public void addLabels() {
		JLabel title = new JLabel();
		title.setText("NENHUM USUÁRIO ENCONTRADO!");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		title.setForeground(Color.BLACK);
		title.setVisible(true);
		title.setBounds(50, 15, 300, 18);
		this.add(title);
		
		JLabel subtitle = new JLabel();
		subtitle.setText("POR FAVOR, SE CADASTRE.");
		subtitle.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		subtitle.setForeground(Color.BLACK);
		subtitle.setVisible(true);
		subtitle.setBounds(100, 36, 250, 14);
		this.add(subtitle);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Nome *");
		nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setVisible(true);
		nameLabel.setBounds(15, 80, 250, 12);
		this.add(nameLabel);
		
		JLabel usernameLabel = new JLabel();
		usernameLabel.setText("Usuário *");
		usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		usernameLabel.setForeground(Color.BLACK);
		usernameLabel.setVisible(true);
		usernameLabel.setBounds(15, 135, 250, 12);
		this.add(usernameLabel);
		
		JLabel password = new JLabel();
		password.setText("Senha *");
		password.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		password.setForeground(Color.BLACK);
		password.setVisible(true);
		password.setBounds(15, 188, 250, 12);
		this.add(password);
	}

	@Override
	public void addButtons() {
		JButton register = new JButton();
		register.setText("Cadastrar");
		register.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		register.setOpaque(true);
		register.setBackground(Color.BLACK);
		register.setForeground(Color.BLACK);
		register.setBounds(95, 255, 200, 30);
		register.addActionListener(new RegisterUserAction(this, this.nameField, this.usernameField, this.passwordField));
		this.add(register);
	}

	@Override
	public void addTextFields() {
		nameField = new JTextField();
		nameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		nameField.setBounds(12, 95, 368, 24);
		this.add(nameField);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		usernameField.setBounds(12, 152, 368, 24);
		this.add(usernameField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passwordField.setBounds(12, 206, 368, 24);
		this.add(passwordField);
	}

}