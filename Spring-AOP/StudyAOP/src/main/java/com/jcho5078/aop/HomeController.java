package com.jcho5078.aop;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
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
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		run1();//AOP 불러오기 테스트
		run2();
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	public void run1() {
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Write write = ctx.getBean("write",Write.class);
		
		write.writeStr();
	}
	
	public void run2() {
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext2.xml");
		Write write = ctx.getBean("write",Write.class);
		
		write.writeStr();
	}
	
}
