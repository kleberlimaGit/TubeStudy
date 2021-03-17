package com.tube.study.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tube.study.dto.FolderDTO;
import com.tube.study.dto.ThumbnailDTO;
import com.tube.study.entities.Folder;
import com.tube.study.repositories.FolderRepository;
import com.tube.study.services.ThumbnailService;

@RestController
@RequestMapping(value = "/thumbnail")
public class ThumbnailResource {
	
	@Autowired
	private ThumbnailService service;
	
	@Autowired
	private FolderRepository folderRepository;
	
	
	@PreAuthorize("hasAnyRole('OPERATOR')")
	@GetMapping(value ="/{id}")
	public ResponseEntity<Page<ThumbnailDTO>> findAll(@PathVariable Long folderId, 
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "6") Integer size,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy){
		
		PageRequest pageRequest = PageRequest.of(page, size,Direction.ASC ,orderBy);
		Folder folder = folderRepository.findById(folderId).get();
		FolderDTO folderDto= new FolderDTO(folder); 
		
		Page<ThumbnailDTO> list = service.findAllThumbnailFromFolder(folderDto, pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	

}
