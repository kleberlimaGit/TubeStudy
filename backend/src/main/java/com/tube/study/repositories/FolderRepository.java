package com.tube.study.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tube.study.entities.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long>{
	
	
	@Query("SELECT f from Folder f "
			+ "JOIN f.user u "
			+ "WHERE  u.id = :userId ")
	Page<Folder> findByUserId(Long userId, Pageable pageRequest);

}
