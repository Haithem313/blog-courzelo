package com.courzelo.courzelo_core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.courzelo.courzelo_core.entity.Post;
import com.courzelo.courzelo_core.service.PostService;

@Controller
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/add/{id}")
    public ResponseEntity<Post> addCart(@RequestBody Post post, @PathVariable("id") long id) throws Exception {
		Post newPost = postService.addPost(post, id);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }
	
	@GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts () {
		List<Post> posts = postService.HomePosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/postById/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long id) throws Exception {
        Post post = postService.findPostById(id);
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable("id") long id) throws Exception {
    	postService.deletePost(id);
    	return new ResponseEntity<Post>(HttpStatus.OK);
    }
    
    @GetMapping("/postByUser/{id}")
    public ResponseEntity<List<Post>> postForProfile(@PathVariable("id") long id) throws Exception {
    	List<Post> posts = postService.findPostByUser(id);
    	return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }
    
    @PutMapping("/updatePost/{id}/{publication}")
    public ResponseEntity<Post> updatePost(@PathVariable String publication, @PathVariable("id") long id) throws Exception {
    	Post updatePost = postService.updatePost(publication, id);
    	return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

}
