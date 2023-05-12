package br.com.controledeveiculos;

import br.com.controledeveiculos.service.UserService;
import br.com.controledeveiculos.view.LoginScreen;
import br.com.controledeveiculos.view.RegisterUserScreen;

public class Main {
	public static void main(String[] args) {
		UserService userService = new UserService();
		boolean hasUser = userService.isThereRegisteredUser();
		if (hasUser) {
			new LoginScreen();
		} else {
			new RegisterUserScreen();
		}
	}
}