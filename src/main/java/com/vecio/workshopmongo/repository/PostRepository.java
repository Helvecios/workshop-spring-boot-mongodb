package com.vecio.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vecio.workshopmongo.domain.Post;

@Repository //annotation 
public interface PostRepository extends MongoRepository<Post, String> {

}
