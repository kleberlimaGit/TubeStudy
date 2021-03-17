package com.tube.study.dto;

import java.io.Serializable;

import com.tube.study.entities.Thumbnail;
import com.tube.study.entities.Video;

public class ThumbnailDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String imgUrl;
	
	private Video video;
	
	private Long folderId;
	

	public ThumbnailDTO() {
		super();
	}
	
	public ThumbnailDTO(Thumbnail entity){
		id = entity.getId();
		imgUrl = entity.getImgUrl();
		video = entity.getVideo();
		folderId = entity.getFolder().getId();
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

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}


	
	
	
}
