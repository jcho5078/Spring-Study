package com.web.security.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.security.user.vo.UserVO;

//Spring Security에서 사용자의 정보를 담는 인터페이스는 UserDetails 인터페이스이다. 
//우리가 이 인터페이스를 구현하게 되면 Spring Security에서 구현한 클래스를 사용자 정보로 인식하고 인증 작업을 한다. 
//쉽게 말하면 UserDetails 인터페이스는 VO 역할을 한다고 보면 된다.
//출처: https://to-dy.tistory.com/86

public class CustomUserDetails implements UserDetails{

	private String id;
	private String pw;
	private String name;
	private String hiredate;
	private String authority;
	private int enabled;//나중에 삽입.
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(authority));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return pw;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {//계정이 사용 가능한 계정인지 확인.
		
		return true;//나중에 삽입.
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
