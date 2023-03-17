package br.com.controledeveiculos.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.controledeveiculos.exception.FailedToFetchUserException;
import br.com.controledeveiculos.service.UserService;
import br.com.controledeveiculos.view.AvailableVehicleListScreen;

public class LoginAction implements ActionListener {
	
	private UserService userService;
	
	private JFrame screen;
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	public LoginAction(JFrame screen, JTextField usernameField, JPasswordField passwordField) {
		this.screen = screen;
		this.usernameField = usernameField;
		this.passwordField = passwordField;
		this.userService = new UserService();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String usernameValue = usernameField.getText();
		char[] passwordChar = passwordField.getPassword();
		String passwordValue = "";
		for (char letter: passwordChar) {
			passwordValue += letter;
		}
		if (usernameValue.trim().length() == 0 || 
				passwordValue.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
		} else {
			try {
				boolean loggedSuccesfully = userService.existsByUsernameAndPassword(usernameValue, passwordValue);
				if (loggedSuccesfully) {
					new AvailableVehicleListScreen();
					screen.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
				}
			} catch (FailedToFetchUserException exception) {
				JOptionPane.showMessageDialog(null, exception.getMessage());
			}
		}
	}

}