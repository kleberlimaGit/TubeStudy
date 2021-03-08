package com.tube.study.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.tube.study.entities.Folder;
import com.tube.study.entities.User;

public class FolderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String imgUrl;
	private String name;
	private User user;
	private Set<ThumbnailDTO> thumbnails = new HashSet<>();

	public FolderDTO() {
		super();
	}

	
	public FolderDTO(Folder entity) {
		id = entity.getId();
		imgUrl = entity.getImgUrl();
		name = entity.getName();
		user = entity.getUser();
		entity.getThumbnail().forEach(thumbnail ->this.thumbnails.add(new ThumbnailDTO(thumbnail)));
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<ThumbnailDTO> getThumbnails() {
		return thumbnails;
	}
	
	

}
