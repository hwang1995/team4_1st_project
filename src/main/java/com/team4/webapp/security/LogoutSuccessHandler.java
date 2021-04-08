package com.team4.webapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	// 로거 사용
	private static final Logger logger = LoggerFactory.getLogger(LogoutSuccessHandler.class);
	
	/**
	 * SimpleUrlLogoutSuccessHandler의 메서드를 재정의함.
	 * 메인페이지의 경로를 띄어줌.
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		logger.info(getDefaultTargetUrl());
		super.onLogoutSuccess(request, response, authentication);
	}
}
