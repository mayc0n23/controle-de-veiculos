package br.com.controledeveiculos.service;

import java.util.List;
import java.util.Optional;

import br.com.controledeveiculos.entity.User;
import br.com.controledeveiculos.exception.FailedToFetchUserException;
import br.com.controledeveiculos.exception.FailedToRegisterUserException;
import br.com.controledeveiculos.repository.UserRepository;

public class UserService {
	
	public static User USER_LOGGED = null;
	
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
	
	public boolean existsByUsernameAndPassword(String username, String password) throws FailedToFetchUserException {
		Optional<User> optionalUser = repository.findByUsernameAndPassword(username, password);
		if (optionalUser.isPresent()) {
			USER_LOGGED = optionalUser.get();
			return true;
		}
		return false;
	}
	
}