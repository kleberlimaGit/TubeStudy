package com.tube.study.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tube.study.entities.Folder;
import com.tube.study.entities.User;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long>{
	
	
	@Query("SELECT f from Folder f "
			+ "WHERE f.user = :user "
			+ "ORDER BY f.name asc")
	Page<Folder> findByUser(User user, Pageable pageRequest);

}
