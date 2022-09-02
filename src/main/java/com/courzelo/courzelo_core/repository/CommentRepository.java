package com.courzelo.courzelo_core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.courzelo.courzelo_core.entity.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Long>{
	
	public List<Comment> findCommentByIdPost(long idPost);

}
