package com.courzelo.courzelo_core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.courzelo.courzelo_core.entity.Post;
import com.courzelo.courzelo_core.entity.User;

@Repository
public interface PostRepository extends MongoRepository<Post, Long>{
	
	void deletePostByIdPost(long idPost);
	
	Post findPostByIdPost(long idPost);
	
	List<Post> findPostByUser(User user);

}
