package com.raulcnunes.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raulcnunes.workshopmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
}
