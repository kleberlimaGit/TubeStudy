package com.tube.study.dto;

import java.io.Serializable;

import com.tube.study.entities.Collection;
import com.tube.study.entities.Thumbnail;
import com.tube.study.entities.Video;

public class ThumbnailDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String imgUrl;
	
	private Video video;
	
	private Collection collection;

	public ThumbnailDTO() {
		super();
	}
	
	public ThumbnailDTO(Thumbnail entity){
		id = entity.getId();
		imgUrl = entity.getImgUrl();
		video = entity.getVideo();
		collection = entity.getCollection();
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

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}
	
	
}
