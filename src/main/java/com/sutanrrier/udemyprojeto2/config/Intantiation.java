package com.sutanrrier.udemyprojeto2.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sutanrrier.udemyprojeto2.domain.User;
import com.sutanrrier.udemyprojeto2.repositories.UserRepository;

@Configuration
public class Intantiation implements CommandLineRunner{

	@Autowired
	UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
	
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		repository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
