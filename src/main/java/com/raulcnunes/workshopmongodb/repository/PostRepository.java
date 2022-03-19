package com.raulcnunes.workshopmongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raulcnunes.workshopmongodb.domain.Post;
import com.raulcnunes.workshopmongodb.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
