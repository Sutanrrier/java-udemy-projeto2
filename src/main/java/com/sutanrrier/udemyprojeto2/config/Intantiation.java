package com.sutanrrier.udemyprojeto2.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sutanrrier.udemyprojeto2.domain.Post;
import com.sutanrrier.udemyprojeto2.domain.User;
import com.sutanrrier.udemyprojeto2.repositories.PostRepository;
import com.sutanrrier.udemyprojeto2.repositories.UserRepository;

@Configuration
public class Intantiation implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
	
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2022"), "Partiu viagem!", "Vou viajar para São Paulo, abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2022"), "Bom dia!", "Acordei feliz hoje!", maria);
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
