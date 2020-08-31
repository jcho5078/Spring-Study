package com.web.security.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	//AuthenticationProvider 인터페이스는 화면에서 입력한 로그인 정보와 DB에서 가져온 사용자의 정보를 비교해주는 인터페이스이다.
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override//authenticate() 메서드는 화면에서 사용자가 입력한 로그인 정보를 담고 있는 Authentication 객체를 가지고 있다.
			//따라서 authenticate() 메서드에서 loadUserByUsernmae() 메서드를 이용해 DB에서 사용자 정보를 가져와서 Authentication 객체에서 화면에서 가져온 로그인 정보와 비교하면 된다.
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		//전역에 생성된 SecurityContextHolder를 이용해 사용자 정보 가져옴.
		String id = (String)authentication.getPrincipal();
		String pw = (String)authentication.getCredentials();
		
		CustomUserDetails user = (CustomUserDetails) userDetailsService.loadUserByUsername(id);
		
		//System.out.println("입력된 유저 비밀번호: " + pw);
		//System.out.println("DB에 저장된 비밀번호: " + user.getPassword());
		
		if(passwordEncoder.matches(pw, user.getPassword())) {//.matchs(입력된 비밀번호, DB에 저장되어있는 비밀번호(스프링 시큐리티로 암호화 된.))
			System.out.println("비밀번호 일치!!!!");
		}else {
			throw new BadCredentialsException("비밀번호 불일치!!!");
		}
		
		if(!user.isEnabled()) {
			throw new BadCredentialsException(id);
		}
		
		//해당유저 권한 부여. UserDetailsService 사용.
		//UsernamePasswordAuthenticationToken은 Authentication 인터페이스의 구현체이다. authentication()의 리턴값은 이 객체로 한다.
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(id, pw, user.getAuthorities());
		
		result.setDetails(userDetailsService);//VO역할을 하는 id, pw, 권한을 부여한 UserDetail을 이용.	
		
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
