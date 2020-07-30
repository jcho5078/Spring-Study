package com.jcho5078.enviroment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:user.properties")//프로퍼티 파일의 값을 클래스로 구현한 스프링 컨테이너
public class TestPropertyConfig {
	
	@Value("${user.Id}")//해당 프로퍼티의 키를통해 값 가져옴
	private String id;
	@Value("${user.Pw}")
	private String pw;
	
	@Autowired//자동으로 스캔하여 enviroment값 가져오기 위함
	private Environment env;
	
	@Bean
	public SetData set() {
		return new SetData(id, pw);
	}
	
	@Bean
	public SetData set2() {
		return new SetData(env.getProperty("user.Id"), env.getProperty("user.Pw"));
	}
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer properties() {//꼭 PropertySourcesPlaceholderConfigurer는 static으로 해야함.
        PropertySourcesPlaceholderConfigurer config = 
        		new PropertySourcesPlaceholderConfigurer();
        //config.setLocation(new ClassPathResource("user.properties"));
        //PropertySourcesPlaceholderConfigurer의 setLocation은 @PropertySource와 같은 역할을 한다. (프로퍼티 파일 지정해주는 역할.)
        return config;
    }
}
