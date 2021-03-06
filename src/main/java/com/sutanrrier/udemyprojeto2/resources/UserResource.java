package com.sutanrrier.udemyprojeto2.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sutanrrier.udemyprojeto2.domain.Post;
import com.sutanrrier.udemyprojeto2.domain.User;
import com.sutanrrier.udemyprojeto2.dto.UserDTO;
import com.sutanrrier.udemyprojeto2.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = service.findById(id);
		UserDTO userDto = new UserDTO(user);
		return ResponseEntity.ok().body(userDto);
	}
	
	@PostMapping
	public ResponseEntity<Object> inserUser(@RequestBody UserDTO objDto){
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado com sucesso!");
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Usuario removido com sucesso!");
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id, @RequestBody UserDTO objDto){
		User obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.status(HttpStatus.OK).body("Usu??rio atualizado com sucesso!");
	}
	
	@GetMapping(value="/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
	}
}
