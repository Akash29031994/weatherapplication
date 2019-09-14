package com.concretio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponse {
	private String status;
	private String message;
	private Object data;
}
