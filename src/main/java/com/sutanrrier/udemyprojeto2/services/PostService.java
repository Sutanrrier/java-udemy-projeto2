package com.sutanrrier.udemyprojeto2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutanrrier.udemyprojeto2.domain.Post;
import com.sutanrrier.udemyprojeto2.repositories.PostRepository;
import com.sutanrrier.udemyprojeto2.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post  = repository.findById(id);
		if(!post.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encotrado");
		}
		return post.get();
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
	
}
