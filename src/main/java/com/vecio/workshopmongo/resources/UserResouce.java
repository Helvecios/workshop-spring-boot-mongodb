package com.vecio.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vecio.workshopmongo.domain.User;
import com.vecio.workshopmongo.dto.UserDTO;
import com.vecio.workshopmongo.services.UserService;

//annotation para falar que é um recurso REST
@RestControllerAdvice
@RequestMapping(value="/users")
public class UserResouce {
	
	//instanciar um objeto do tipo UserService
	@Autowired //annotation para instaciar um serviço automaticamente
	private UserService service;
	
	//método lista de usuários
	//para informar que este método vai ser um end point rest no caminho "/users"
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		//preenche a lista buscando os usuários no BD
		List<User> list = service.findAll();
		//converter a lista de User para lista UserDTO
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); //usando função labda
		return ResponseEntity.ok(listDto);
		
	}
	
	

}
