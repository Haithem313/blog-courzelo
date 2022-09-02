package com.courzelo.courzelo_core.entity;

import java.time.Instant;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Like {
	
	@Transient
    public static final String SEQUENCE_NAME = "like_sequence";
	
	@Id
	private long id ;
	private User user;
	private long idPost;


}
