package com.vecio.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vecio.workshopmongo.domain.User;
import com.vecio.workshopmongo.repository.UserRepository;

@Service //annotation para informar que é um serviço que pode ser injetado em outra classe
public class UserService {
	
	//instanciar um objeto do tipo UserRepository
	@Autowired //annotation para instaciar um serviço automaticamente
	private UserRepository repo;
	
	//metodo para retornar todos os Users
	public List<User> findAll() {
		return repo.findAll();
				
	}

}
