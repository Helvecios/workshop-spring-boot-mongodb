package com.vecio.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vecio.workshopmongo.domain.User;
import com.vecio.workshopmongo.dto.UserDTO;
import com.vecio.workshopmongo.repository.UserRepository;
import com.vecio.workshopmongo.services.exception.ObjectNotFoundException;

@Service //annotation para informar que é um serviço que pode ser injetado em outra classe
public class UserService {
	
	//instanciar um objeto do tipo UserRepository
	@Autowired //annotation para instaciar um serviço automaticamente
	private UserRepository repo;
	
	//metodo para retornar todos os Users
	public List<User> findAll() {
		return repo.findAll();
	}
	
	//método findById
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	//método para inserir um User
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	//método para deletar um User
	public void delete(String id) {
		findById(id); //usar o método findById para procurar o id a ser deletado
		repo.deleteById(id);
	}
	
	//método para atualizar um User
	public User update(User obj) {
		//instaciar um obj usuário que será atualizado
		User newObj = findById(obj.getId());
		updateData(newObj, obj); //responsável por copiar os dados do "obj" para o "newObj"
		return repo.save(newObj);
 }
	
	//método para atualizar o newObj com os dados  	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	//método para receber um UserDTO objDTO
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
