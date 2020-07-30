package com.jcho5078.enviroment;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		run1();//테스트용 메소드 출력
		
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	public void run1() {//@Value를 이용한 프로퍼티 불러오는 방법
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(TestPropertyConfig.class);
		
		SetData setData = ctx.getBean("set", SetData.class);
		setData.print();
	}
	
	public void run2() {//Env.getProperty 이용해 프로퍼티 불러오는 방법
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(TestPropertyConfig.class);
		
		SetData setData = ctx.getBean("set2", SetData.class);
		setData.print2();
	}
	
	public void run3() {//프로파일을 사용하여 프로퍼티 불러오는 방법
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(TestProfileConfig.class);
		
		SetData setData = ctx.getBean("set", SetData.class);
		setData.print();
	}
	
}
