package br.com.controledeveiculos.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.controledeveiculos.entity.User;
import br.com.controledeveiculos.exception.FailedToUpdateUserException;
import br.com.controledeveiculos.service.UserService;
import br.com.controledeveiculos.view.AvailableVehicleListScreen;

public class EditUserAction implements ActionListener {
	
	private UserService userService;
	
	private JFrame screen;
	
	private JTextField nameField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	public EditUserAction(JFrame screen, JTextField nameField, JTextField usernameField, JPasswordField passwordField) {
		this.screen = screen;
		this.nameField = nameField;
		this.usernameField = usernameField;
		this.passwordField = passwordField;
		this.userService = new UserService();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nameValue = nameField.getText();
		String usernameValue = usernameField.getText();
		char[] passwordChar = passwordField.getPassword();
		String passwordValue = "";
		for (char letter: passwordChar) {
			passwordValue += letter;
		}
		if (nameValue.trim().length() == 0 || usernameValue.trim().length() == 0 || 
				passwordValue.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
		} else {
			User user = new User();
			user.setId(UserService.USER_LOGGED.getId());
			user.setName(nameValue.trim());
			user.setUsername(usernameValue.trim());
			user.setPassword(passwordValue.trim());
			try {
				userService.update(user);
				UserService.USER_LOGGED = user;
				new AvailableVehicleListScreen();
				screen.dispose();
			} catch (FailedToUpdateUserException exception) {
				JOptionPane.showMessageDialog(null, exception.getMessage());
			}
		}
	}

}