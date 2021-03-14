package com.tube.study.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tube.study.dto.FolderDTO;
import com.tube.study.services.FolderService;

@RestController
@RequestMapping(value = "/folders")
public class FolderResource {

	@Autowired
	private FolderService service;
	
	
	@GetMapping
	public ResponseEntity<Page<FolderDTO>> findAll(
			
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "6") Integer size
			){
		
		PageRequest pageRequest = PageRequest.of(page, size);
		
		Page<FolderDTO> list = service.folderForCurrentUser(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
}
