package com.jcho5078.enviroment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("profile")//변하는 환경에도 코드를 바꾸는 불편한 경우를 줄이기 위해 각기 다른 이름의 프로파일을 설정하여 각 환경에 맞는 설정 정보를 따로 만들고, 환경에 맞는 프로필을 선택하면 된다.
public class TestProfileConfig {
	
	@Value("${user.Id}")//해당 프로퍼티의 키를통해 값 가져옴
	private String id;
	@Value("${user.Pw}")
	private String pw;
	
	@Bean
	public SetData set() {
		return new SetData(id, pw);
	}
}
