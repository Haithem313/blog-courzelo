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

import com.courzelo.courzelo_core.entity.Comment;
import com.courzelo.courzelo_core.entity.Post;
import com.courzelo.courzelo_core.service.CommentService;

@Controller
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/add/{idUser}/{idPost}")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment, @PathVariable("idUser") long idUser, @PathVariable("idPost") long idPost) throws Exception {
		Comment newComment = commentService.addComment(comment, idUser, idPost);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }
	
	@GetMapping("/getComments/{idPost}")
    public ResponseEntity<List<Comment>> getCommentByPost (@PathVariable("idPost") long idPost) {
		List<Comment> posts = commentService.getCommentByPost(idPost);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
	
	@DeleteMapping("/deleteComment/{idComment}")
	public void deleteComment(@PathVariable("idComment") long idComment){
		commentService.deleteComment(idComment);
	}
	
	@GetMapping("/getCommentById/{idComment}")
	public ResponseEntity<Comment> getCommentById (@PathVariable("idComment") long idComment) {
		Comment comment = commentService.getCommentById(idComment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
	
	@PutMapping("/update/{idComment}/{commentaire}")
	public ResponseEntity<Comment> updateComment(@PathVariable("idComment")long idComment, @PathVariable("commentaire") String commentaire){
		Comment comment = commentService.updateComment(idComment, commentaire);
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}

}
