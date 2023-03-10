package br.com.controledeveiculos.service;

import java.util.List;

import br.com.controledeveiculos.entity.User;
import br.com.controledeveiculos.exception.FailedToRegisterUserException;
import br.com.controledeveiculos.repository.UserRepository;

public class UserService {
	
	private UserRepository repository;
	
	public UserService() {
		this.repository = new UserRepository();
	}
	
	public boolean isThereRegisteredUser() {
		List<User> users = this.repository.findAll();
		return users.size() != 0 ? true : false;
	}
	
	public void register(User user) throws FailedToRegisterUserException {
		repository.save(user);
	}
	
}