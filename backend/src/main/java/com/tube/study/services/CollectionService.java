package com.tube.study.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tube.study.dto.CollectionDTO;
import com.tube.study.dto.ThumbnailDTO;
import com.tube.study.entities.Collection;
import com.tube.study.entities.Thumbnail;
import com.tube.study.entities.User;
import com.tube.study.repositories.CollectionRepository;
import com.tube.study.repositories.ThumbnailRepository;
import com.tube.study.repositories.UserRepository;

@Service
@Transactional
public class CollectionService {
	
	@Autowired
	private CollectionRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ThumbnailRepository thumbnailRepository;
	
	public Page<CollectionDTO> findAllPaged(Long userId, PageRequest pageRequest){
		
		Page<Collection> list = repository.findByUserId(userId,pageRequest);
		
		Page<CollectionDTO> listDto = list.map(x -> new CollectionDTO(x));
		
		return listDto;
		
	}
	
	public CollectionDTO insertCollect(CollectionDTO dto, Long id) {
		
		Collection collection = new Collection();
		copyDtoToEntity(dto, collection);
		collection = repository.save(collection);
		return new CollectionDTO(collection);
	}
	
	
private void copyDtoToEntity(CollectionDTO dto, Collection entity) {
		
		entity.setImgUrl(dto.getImgUrl());
		entity.setName(dto.getName());
		entity.getThumbnail().clear();
		for(ThumbnailDTO thumbDto: dto.getThumbnails()) {
			Thumbnail thumbnail = thumbnailRepository.getOne(thumbDto.getId());
			entity.getThumbnail().add(thumbnail);
		}
	
}
}
