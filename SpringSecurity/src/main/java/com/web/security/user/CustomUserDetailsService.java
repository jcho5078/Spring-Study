package com.web.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.web.security.user.dao.UserDAO;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		//loadUserByUsername에서 데이터베이스에 접근한다.
		CustomUserDetails user = userDAO.login(id);
		
		if(id == null) {
			throw new UsernameNotFoundException(id);
		}
		
		return user;
	}

}
