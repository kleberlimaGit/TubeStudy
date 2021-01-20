package com.tube.study.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tube.study.entities.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{

}
