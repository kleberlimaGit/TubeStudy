package com.tube.study.dto;

import com.tube.study.entities.Video;

public class VideoDTO {

	private Long id;
	private String url;
	private String text;
	
	public VideoDTO() {
		
	}

	public VideoDTO(Long id, String url, String text) {
		super();
		this.id = id;
		this.url = url;
		this.text = text;
	}
	
	public VideoDTO(Video entity) {
		id = entity.getId();
		url = entity.getUrl();
		text = entity.getText();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
