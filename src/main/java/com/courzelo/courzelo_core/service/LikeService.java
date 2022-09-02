package com.courzelo.courzelo_core.service;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.courzelo.courzelo_core.entity.Like;
import com.courzelo.courzelo_core.entity.Post;
import com.courzelo.courzelo_core.entity.User;
import com.courzelo.courzelo_core.repository.LikeRepository;
import com.courzelo.courzelo_core.repository.PostRepository;

@Service
public class LikeService {
	
	@Autowired
	LikeRepository likeRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	private static final String GET_USER_BY_ID_API = "http://localhost:8082/api/auth/getUser/{id}";
	
	public User getUserByRestTemplate(long id){
		Map<String, Long> param = new HashMap<>();
		param.put("id", id);
		User user = restTemplateBuilder.build().getForObject(GET_USER_BY_ID_API, User.class, param);
		return user;
	}

	public int addLike(long idUser, long idPost){
		Like like = new Like();
		User user = getUserByRestTemplate(idUser);
		Post post = postRepository.findById(idPost).get();
		List<Like> likes = likeRepository.findAll();
		for(Like likee : likes) {
			if(likee.getUser().getId() == idUser && likee.getIdPost() == idPost){
				 likeRepository.deleteById(likee.getId());
				 post.setLikes(post.getLikes()-1);
				 postRepository.save(post);
				 return 1;
			}
		}
		like.setId(sequenceGeneratorService.generateSequence(Like.SEQUENCE_NAME));
		like.setUser(user);
		like.setIdPost(idPost);
		likeRepository.save(like);
		post.setLikes(post.getLikes()+1);
		postRepository.save(post);		
		return 0;
		
	}
	
	public boolean Liked(long idUser, long idPost){
		List<Like> likes = likeRepository.findAll();
		for(Like likee : likes) {
			if(likee.getUser().getId() == idUser && likee.getIdPost() == idPost){
				 return true;
			}
			else return false;
		}
		return false;
		
	}

	public List<Like> getAllLikes() {
	  return likeRepository.findAll();


	}

	public long countLikes() {
	  return likeRepository.count();

	}

}
