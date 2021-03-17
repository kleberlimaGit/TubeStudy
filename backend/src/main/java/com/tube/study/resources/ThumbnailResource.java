package com.tube.study.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tube.study.dto.ThumbnailDTO;
import com.tube.study.services.ThumbnailService;

@RestController
@RequestMapping(value = "/thumbnail")
public class ThumbnailResource {
	
	@Autowired
	private ThumbnailService service;
	
	
	@GetMapping(value ="/folder/{folderId}")
	public ResponseEntity<Page<ThumbnailDTO>> findAllByFolder(@PathVariable Long folderId, 
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "9") Integer size){
		
		PageRequest pageRequest = PageRequest.of(page, size); 
		
		Page<ThumbnailDTO> list = service.findAllThumbnailFromFolder(folderId, pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	

}
