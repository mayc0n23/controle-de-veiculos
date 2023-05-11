package br.com.controledeveiculos.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.controledeveiculos.actions.EditUserAction;
import br.com.controledeveiculos.components.MenuBar;
import br.com.controledeveiculos.service.UserService;
import br.com.controledeveiculos.view.template.LowView;

public class EditUserScreen extends LowView {

	private static final long serialVersionUID = -517988518311970689L;
	
	private JTextField nameField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	public EditUserScreen() {
		this.setTitle(this.getTitle() + "Editar usuário");
		this.addMenu();
		this.populateData();
		this.setVisible(true);
	}

	@Override
	public void addLabels() {
		JLabel title = new JLabel();
		title.setText("EDITAR DADOS");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		title.setForeground(Color.BLACK);
		title.setVisible(true);
		title.setBounds(120, 25, 300, 18);
		this.add(title);
		
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
		JButton save = new JButton();
		save.setText("Salvar");
		save.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		save.setOpaque(true);
		save.setBackground(Color.BLACK);
		save.setForeground(Color.BLACK);
		save.setBounds(95, 255, 200, 30);
		save.addActionListener(new EditUserAction(this, this.nameField, this.usernameField, this.passwordField));
		this.add(save);
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
	
	private void addMenu() {
		this.setJMenuBar(new MenuBar(this));
	}
	
	private void populateData() {
		nameField.setText(UserService.USER_LOGGED.getName());
		usernameField.setText(UserService.USER_LOGGED.getUsername());
		passwordField.setText(UserService.USER_LOGGED.getPassword());
	}

}