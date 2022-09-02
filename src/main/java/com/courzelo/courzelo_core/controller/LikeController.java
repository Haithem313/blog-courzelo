package com.courzelo.courzelo_core.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courzelo.courzelo_core.entity.Like;
import com.courzelo.courzelo_core.service.LikeService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = { "/like" }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class LikeController {
	
	@Autowired
	LikeService likeService;

	    @PostMapping("/add/{idUser}/{idPost}")
	    public ResponseEntity<Like> addLike(@PathVariable("idUser") long idUser, @PathVariable("idPost") long idPost){
	        likeService.addLike(idUser, idPost);
	        return new ResponseEntity<Like>(HttpStatus.CREATED);
	    }
	    
	    @GetMapping("/liked/{idUser}/{idPost}")
	    public boolean liked(@PathVariable("idUser") long idUser, @PathVariable("idPost") long idPost){
	    	return likeService.Liked(idUser, idPost);	    	
	    }


}
