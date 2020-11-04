package com.vecio.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vecio.workshopmongo.domain.Post;

@Repository //annotation 
public interface PostRepository extends MongoRepository<Post, String> {
	
	//método para realizar busca pelo título
	List<Post> findByTitleContainingIgnoreCase(String text); //IgnoreCase para não fazer distinção entre maiúsculo e minúscula
	

}
