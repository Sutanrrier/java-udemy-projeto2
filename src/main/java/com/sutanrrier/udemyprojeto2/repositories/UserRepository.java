package com.sutanrrier.udemyprojeto2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sutanrrier.udemyprojeto2.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
