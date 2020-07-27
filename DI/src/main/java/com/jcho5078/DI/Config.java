package com.jcho5078.DI;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.jcho5078.user.UserRepository;
import com.jcho5078.user.UserVO;

//클래스에서 DI 설정
@Configuration
//@ImportResource("classpath:applicationContext.xml") XML에서 설정한 값을 클래스에서 사용하고 싶을 때 사용.
public class Config {
	
	//빈 객체 생성. 메소드 이름은 해당 bean의 id, 리턴값은 해당 빈 객체의 값.
	@Bean
	public UserVO user1() {
		return new UserVO("man1", "1234");
	}
	
	@Bean
	public UserRepository userRepository() {//해당 빈의 id는 userRepository
		UserRepository userRepo = new UserRepository();
		userRepo.setUser(Arrays.asList(user1()));
		return userRepo; //지역내 설정한 userRepo객체의 설정값을 리턴.
	}
}
