package com.courzelo.courzelo_core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.courzelo.courzelo_core.entity.Like;

@Repository
public interface LikeRepository extends MongoRepository<Like, Long>{

}
