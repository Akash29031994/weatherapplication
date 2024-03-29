package com.concretio.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/*
 * Create by Akash Chaturvedi   
 */

@Getter()
@Setter()
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	public JwtRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
}