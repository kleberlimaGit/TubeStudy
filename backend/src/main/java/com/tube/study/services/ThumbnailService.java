package com.tube.study.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tube.study.dto.FolderDTO;
import com.tube.study.dto.ThumbnailDTO;
import com.tube.study.entities.Folder;
import com.tube.study.entities.Thumbnail;
import com.tube.study.entities.User;
import com.tube.study.repositories.FolderRepository;
import com.tube.study.repositories.ThumbnailRepository;

@Service
@Transactional
public class ThumbnailService {
	
	@Autowired
	private ThumbnailRepository repository;
	
	@Autowired
	private FolderRepository folderRepository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<ThumbnailDTO> findAllThumbnailFromFolder(FolderDTO folderDto, Pageable pageable){
		User user = authService.authenticated();
		Folder folder = folderRepository.getOne(folderDto.getId());
		
		Page<Thumbnail> page = repository.findByFolder(user, folder, pageable);
		
		return page.map(thumbnail -> new ThumbnailDTO(thumbnail));
	}
}
