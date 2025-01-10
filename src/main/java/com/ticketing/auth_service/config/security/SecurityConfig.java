package com.ticketing.auth_service.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ticketing.auth_service.service.JwtProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

	private final AuthenticationConfiguration authenticationConfiguration;
	private final JwtProvider jwtProvider;

	private static final String[] WHITE_LIST = {"/login", "/test"};

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager(authenticationConfiguration), jwtProvider);

		http
				.csrf(csrf -> csrf.disable()) //CSRF 보호를 비활성화. REST API 환경만 비활성화. Web Form 기반에서는 필요.
				.formLogin((auth) -> auth.disable()) // 기본 로그인 페이지 사용 안함
				.headers(header -> header.frameOptions(
						frameOptionsConfig -> frameOptionsConfig.disable())
				) // X-Frame-Options 비활성화
				.authorizeHttpRequests(authz -> authz
						.requestMatchers(WHITE_LIST).permitAll()
						.anyRequest()
						.authenticated()
				)
				.addFilterAt(authenticationFilter, UsernamePasswordAuthenticationFilter.class) // 필터 추가
				.sessionManagement((session) -> session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
