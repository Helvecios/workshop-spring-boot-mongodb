package com.vecio.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vecio.workshopmongo.domain.User;

@Repository //annotation 
public interface UserRepository extends MongoRepository<User, String> {

}
