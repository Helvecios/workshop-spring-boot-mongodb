package com.vecio.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vecio.workshopmongo.domain.User;

//annotation para falar que é um recurso REST
@RestControllerAdvice
@RequestMapping(value="/users")
public class UserResouce {
	
	//método lista de usuários
	//para informar que este método vai ser um end point rest no caminho "/users"
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		//instaciar os objetos maria e alex
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		//criar nova lista de usuários
		List<User> list = new ArrayList<>();
		//adicionar a maria e o alex na lista
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok(list);
		
	}
	
	

}
