package com.courzelo.courzelo_core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the user database table.
 * 
 */
@Document
@Getter
@Setter
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 65981149772133526L;
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private Long id;

	private String providerUserId;

	private String email;

	private String displayName;

	public User(Long id, String providerUserId, String email, String displayName) {
		super();
		this.id = id;
		this.providerUserId = providerUserId;
		this.email = email;
		this.displayName = displayName;
	}

	public User() {
		super();
	}
	
	
}