package com.courzelo.courzelo_core.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	
	@Transient
    public static final String SEQUENCE_NAME = "comment_sequence";
	
	@Id
	private long idComment;
	
	private String commentaire;
	
	@Field(value = "Date")
    private String date;

    @Field(value = "IdPost")
    private long idPost;
	
	private User user;
	

}
