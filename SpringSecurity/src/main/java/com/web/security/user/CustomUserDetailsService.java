package com.web.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.web.security.user.dao.UserDAO;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException, BadCredentialsException {
		//loadUserByUsername에서 데이터베이스에 접근한다.
		CustomUserDetails user = userDAO.login(id);
		System.out.println("details 유저 비밀번호: " + user.getPassword());
		
		if(id == null) {
			throw new UsernameNotFoundException(id);
		}
		
		return user;
	}
	
	public String EncodingPw(String pw) {//회원가입시 pw 암호화 인코딩 위함
		
		String encPassword = passwordEncoder.encode(pw);
		
		System.out.println("회원가입 pw 인코딩: "+ encPassword);
		
		return encPassword;
	}

}
