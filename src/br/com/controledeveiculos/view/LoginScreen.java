package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.controledeveiculos.actions.LoginAction;
import br.com.controledeveiculos.view.template.LowView;

public class LoginScreen extends LowView {

	private static final long serialVersionUID = -8680177566411949097L;
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	public LoginScreen() {
		this.setTitle(this.getTitle() + "Login");
		this.setVisible(true);
	}

	@Override
	public void addLabels() {
		JLabel title = new JLabel();
		title.setText("INSIRA SUAS CREDENCIAIS DE ACESSO!");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		title.setForeground(Color.BLACK);
		title.setVisible(true);
		title.setBounds(45, 15, 300, 18);
		this.add(title);
		
		JLabel usernameLabel = new JLabel();
		usernameLabel.setText("Usuário *");
		usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		usernameLabel.setForeground(Color.BLACK);
		usernameLabel.setVisible(true);
		usernameLabel.setBounds(15, 80, 250, 12);
		this.add(usernameLabel);
		
		JLabel password = new JLabel();
		password.setText("Senha *");
		password.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		password.setForeground(Color.BLACK);
		password.setVisible(true);
		password.setBounds(15, 138, 250, 12);
		this.add(password);
	}

	@Override
	public void addButtons() {
		JButton login = new JButton();
		login.setText("Entrar");
		login.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		login.setOpaque(true);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.BLACK);
		login.setBounds(95, 230, 200, 30);
		login.addActionListener(new LoginAction(this, this.usernameField, this.passwordField));
		this.add(login);
	}

	@Override
	public void addTextFields() {
		usernameField = new JTextField();
		usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		usernameField.setBounds(12, 97, 368, 24);
		this.add(usernameField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passwordField.setBounds(12, 151, 368, 24);
		this.add(passwordField);
	}

}