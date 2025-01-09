package com.ticketing.auth_service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginRequest {
	private String username;
	private String password;
}
