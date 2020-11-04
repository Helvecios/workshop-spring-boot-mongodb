package com.vecio.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vecio.workshopmongo.domain.Post;
import com.vecio.workshopmongo.repository.PostRepository;
import com.vecio.workshopmongo.services.exception.ObjectNotFoundException;

@Service //annotation para informar que é um serviço que pode ser injetado em outra classe
public class PostService {
	
	//instanciar um objeto do tipo UserRepository
	@Autowired //annotation para instaciar um serviço automaticamente
	private PostRepository repo;
	
	//método findById para Post do id
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	//método de busca pelo título
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text); 
	}
}
