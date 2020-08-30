package com.web.security.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	//AuthenticationProvider 인터페이스는 화면에서 입력한 로그인 정보와 DB에서 가져온 사용자의 정보를 비교해주는 인터페이스이다.
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override//authenticate() 메서드는 화면에서 사용자가 입력한 로그인 정보를 담고 있는 Authentication 객체를 가지고 있다.
			//따라서 authenticate() 메서드에서 loadUserByUsernmae() 메서드를 이용해 DB에서 사용자 정보를 가져와서 Authentication 객체에서 화면에서 가져온 로그인 정보와 비교하면 된다.
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		//전역에 생성된 SecurityContextHolder를 이용해 사용자 정보 가져옴.
		String id = (String)authentication.getPrincipal();
		String pw = (String)authentication.getCredentials();
		
		CustomUserDetails user = (CustomUserDetails) userDetailsService.loadUserByUsername(id);
		
		System.out.println("Welcome, authentication "+id+", "+pw);
		
		if(!matchPassword(id, pw)) {
			System.out.println("id, pw 안맞음.");
		}
		
		if(!user.isEnabled()) {
			System.out.println("사용 가능한 계정이 아닙니다.");
		}
		
		//해당유저 권한 부여. 방법 1. UserDetailsService 구현 안했을 때.
		//List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        //roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		//해당유저 권한 부여. 방법 2. UserDetailsService 사용 했을때.
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(id, pw, user.getAuthorities());
		//UsernamePasswordAuthenticationToken은 Authentication 인터페이스의 구현체이다. authentication()의 리턴값은 이 객체로 한다.
		
		result.setDetails(userDetailsService);//VO역할을 하는 id, pw, 권한을 부여한 UserDetail을 이용.	
		
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	private boolean matchPassword(String loginPwd, String password) {
        return loginPwd.equals(password);
    }

}
