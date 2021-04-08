package com.team4.webapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	// 로거 사용
	private static final Logger logger = LoggerFactory.getLogger(AuthFailureHandler.class);
	
	/**
	 * SimpleUrlAuthenticationFailureHandler에서 재정의하여 작성한 메서드
	 * Exception 메시지를 띄움.
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		logger.info(exception.getMessage());
		super.onAuthenticationFailure(request, response, exception);
	}
}
