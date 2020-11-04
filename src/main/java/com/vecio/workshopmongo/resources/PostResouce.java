package com.vecio.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vecio.workshopmongo.domain.Post;
import com.vecio.workshopmongo.resources.util.URL;
import com.vecio.workshopmongo.services.PostService;

//annotation para falar que é um recurso REST
@RestControllerAdvice
@RequestMapping(value="/posts")
public class PostResouce {
	
	//instanciar um objeto do tipo UserService
	@Autowired //annotation para instaciar um serviço automaticamente
	private PostService service;
		
	//método findById (retornando o DTO)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		//instanciar um obj usuário
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//método para fazer a busca pelo título (endpoint)
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		//decodificar o texto
		text = URL.decodeParam(text);
		//declarar uma lista de Post e chama o serviço de busca pelo título
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
