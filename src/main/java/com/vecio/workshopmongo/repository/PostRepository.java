package com.vecio.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vecio.workshopmongo.domain.Post;

@Repository //annotation 
public interface PostRepository extends MongoRepository<Post, String> {
	
	//método alternativo (personalizado) de consulta pelo título
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	//método para realizar busca pelo título
	//List<Post> findByTitleContainingIgnoreCase(String text); //IgnoreCase para não fazer distinção entre maiúsculo e minúscula
	
	//método de consulta com vários critérios
	@Query("{ $and: [ {date: {$gte: ?1} }, {date: {$lte: ?2}}, {$or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'doby': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
