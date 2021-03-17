package com.tube.study.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tube.study.entities.Folder;
import com.tube.study.entities.Thumbnail;
import com.tube.study.entities.User;

@Repository
public interface ThumbnailRepository extends JpaRepository<Thumbnail, Long>{
	
	
	@Query("Select t from Thumbnail t "
			+ "join t.folder f "
			+ "where t.folder = :folder "
			+ "and f.user = :user "
			+ "order by t.id asc")
	Page<Thumbnail> findByFolder(User user ,Folder folder, Pageable pageable);
}
