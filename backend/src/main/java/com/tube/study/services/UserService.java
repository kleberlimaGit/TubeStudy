package com.tube.study.services;



import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tube.study.dto.CollectionDTO;
import com.tube.study.dto.RoleDTO;
import com.tube.study.dto.UserDTO;
import com.tube.study.entities.Collection;
import com.tube.study.entities.Role;
import com.tube.study.entities.User;
import com.tube.study.repositories.CollectionRepository;
import com.tube.study.repositories.RoleRepository;
import com.tube.study.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private CollectionRepository collectionRepository;
	
	private RoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(PageRequest pageRequest){
		
		Page<User> user = repository.findAll(pageRequest);
		
		Page<UserDTO> userDto = user.map(x -> new UserDTO(x));
		
		return userDto;
	}
	
	
	public UserDTO InsertUser(UserDTO dto) {
		User user = new User();
		copyDtoToEntity(dto, user);
		
		user = repository.save(user);
		return new UserDTO(user);
		
	}
	
	public UserDTO updateUser(Long id, UserDTO dto) {
		try {
			User user  = repository.getOne(id);
			copyDtoToEntity(dto, user);
			user = repository.save(user);
			return new UserDTO(user);
		}
		catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Identificador não encontrado: " + id);
		}
	}
		
		public void delete(Long id) {
			try {
			repository.deleteById(id);
			
			}
			catch (EntityNotFoundException e) {
				throw new EntityNotFoundException("Identificador não encontrado: " + id);
			}
	}
	
	
	
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());		
		entity.getCollections().clear();
		for(CollectionDTO collectionDto: dto.getCollections()) {
			Collection collection = collectionRepository.getOne(collectionDto.getId());
			entity.getCollections().add(collection);
		}
		entity.getRoles().clear();
		for(RoleDTO roleDto : dto.getRoles()) {
			Role role = roleRepository.getOne(roleDto.getId());
			entity.getRoles().add(role);
		}
		
	}
}
