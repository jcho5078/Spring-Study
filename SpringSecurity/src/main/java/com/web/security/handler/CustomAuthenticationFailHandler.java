package com.web.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailHandler implements AuthenticationFailureHandler {
	//인증 실패시 메세지 출력용 클래스
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		System.out.println(exception.getClass().getSimpleName());
		System.out.println(exception.getClass().getName());
		
		System.out.print("로그인 실패");
		
		if(exception.getClass().getSimpleName().equals("BadCredentialsException")){
			request.setAttribute("error", "login");
		}else if(exception.getClass().getSimpleName().equals("SessionAuthenticationException")){
			request.setAttribute("error", "duplicate");
		}else if(exception.getClass().getSimpleName().equals("UsernameNotFoundException")){
			request.setAttribute("error", "not found");
		}
		
		System.out.println("error: "+request.getAttribute("error"));
		
		//request.getRequestDispatcher("/user/loginTest").forward(request, response);
		
	}

}
