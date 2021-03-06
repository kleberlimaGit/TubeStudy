package com.tube.study.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tube.study.entities.Thumbnail;

@Repository
public interface ThumbnailRepository extends JpaRepository<Thumbnail, Long>{

}
