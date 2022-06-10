package com.sutanrrier.udemyprojeto2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutanrrier.udemyprojeto2.domain.User;
import com.sutanrrier.udemyprojeto2.repositories.UserRepository;
import com.sutanrrier.udemyprojeto2.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		if(!user.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encotrado");
		}
		return user.get();
	}
	
}
