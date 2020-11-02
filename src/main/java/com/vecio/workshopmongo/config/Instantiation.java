package com.vecio.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vecio.workshopmongo.domain.User;
import com.vecio.workshopmongo.repository.UserRepository;

@Configuration //annotation para o Spring entender que isso é uma configuração
public class Instantiation implements CommandLineRunner{

	//injetar o UserRepository para fazer a operação com o BD
	@Autowired
	private UserRepository userRepository;
		
	//método para instanciar objetos e salvar no BD
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll(); //para limpar a coleção no MogoDB
		
		//instanciar os objetos
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//salvar os objetos na coleção de usuários
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
