package com.concretio.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * Create by Akash Chaturvedi   
 */

@Getter
@Setter
public class APIResponse {
	private String status;
	private String message;
	private Object data;
}
