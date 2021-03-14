package com.tube.study.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tube.study.dto.FolderDTO;
import com.tube.study.entities.Folder;
import com.tube.study.entities.User;
import com.tube.study.repositories.FolderRepository;

@Service
public class FolderService {

	@Autowired
	private FolderRepository repository;
	
	@Autowired
	private AuthService authService;
	
	public Page<FolderDTO> folderForCurrentUser(Pageable pageable){
		User user = authService.authenticated();
		Page<Folder> page = repository.findByUser(user, pageable);
		
		return page.map(x -> new FolderDTO(x));
	}
}
