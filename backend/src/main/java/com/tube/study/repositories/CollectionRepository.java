package com.tube.study.repositories;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tube.study.entities.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long>{
	
	
	@Query("SELECT c from Collection c "
			+ "JOIN c.user u "
			+ "WHERE  u.id = :userId ")
	Page<Collection> findByUserId(Long userId, Pageable pageRequest);

}
