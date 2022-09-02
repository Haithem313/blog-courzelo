package com.courzelo.courzelo_core.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.courzelo.courzelo_core.entity.Post;
import com.courzelo.courzelo_core.entity.User;
import com.courzelo.courzelo_core.repository.PostRepository;

@Service
public class PostService {
	
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
	
	public Post addPost(Post post, long id){
		User user = getUserByRestTemplate(id);
		post.setIdPost(sequenceGeneratorService.generateSequence(Post.SEQUENCE_NAME));
		post.setUser(user);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		post.setDate(date);
		return postRepository.save(post);
	}
	
	public Post findPostById(long idPost){
		return postRepository.findPostByIdPost(idPost);
	}
	
	public List<Post> findPostByUser(long id){
		User user = getUserByRestTemplate(id);
		return postRepository.findPostByUser(user);
	}
	
	public List<Post> HomePosts(){
		return postRepository.findAll();
	}
	
	public void deletePost(long id){
		postRepository.deleteById(id);
	}
	
	public Post updatePost(String publication, long id){
		Post post = postRepository.findById(id).get();
		post.setPublication(publication);
		//post.setTypefile(postDetails.getTypefile());
		return postRepository.save(post);
		
	}
	


}
