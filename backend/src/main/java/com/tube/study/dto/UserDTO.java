package com.tube.study.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.tube.study.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String email;
	
	private String password;
	
	private Set<CollectionDTO> collections = new HashSet<>();

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		email = entity.getEmail();
		password = entity.getPassword();
		entity.getCollection().forEach(collection -> this.collections.add(new CollectionDTO(collection)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<CollectionDTO> getCollections() {
		return collections;
	}
	
	
}
