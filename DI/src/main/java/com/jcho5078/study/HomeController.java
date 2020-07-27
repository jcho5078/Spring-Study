package com.jcho5078.study;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcho5078.DI.Config;
import com.jcho5078.ref.RefMain;
import com.jcho5078.user.UserRepository;
import com.jcho5078.user.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		runTest1();
		runTest2();
		runTest3();
		
		return "home";
	}
	
	public void runTest1() {//DI 실행 테스트 용
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		UserVO userVO = ctx.getBean("userVO", UserVO.class);
		
		System.out.println(userVO.getId());//"man"이 출력됨.
		
		ctx.close();
	}
	
	public void runTest2() {
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//RefMain refMain = ctx.getBean("refMain", RefMain.class); 이것은 객체를 생성하는것이 아닌 빈 객체를 불러올 뿐이다.(인스턴스 생성 대신 bean불러오기)
		//객체 생성과 동시에 refSub빈의 생성자에 있는 print문에 설정한 "출력"이란 문자열 출력
		/*"출력"이라는 문자열은 총 4번 출력 됨. runTest1()메소드를 실행함으로서 XML파일에서 생성한 두 개의 RefMain빈객체를 출력, runTest2()에서 두번 출력.
			65번 라인의 주석을 해체하더라도 "출력"문자열이 4번 출력되는건 마찬가지다. GenericXmlApplicationContext를 통해 XML파일에 있는 빈객체를 전부 생성하기 때문.
		*/
		ctx.close();
	}
	
	public void runTest3() {
		AnnotationConfigApplicationContext ctx = //클래스로 설정한 빈 객체를 불러오려면 AnnotationConfigApplication클래스를 사용한다.
				new AnnotationConfigApplicationContext(Config.class);
		UserRepository userRepository = ctx.getBean("userRepository", UserRepository.class); 
		//Config클래스에 설정한 빈객체 출력. Config내 user1이라는 빈객체의 값인 userId를 출력한다. 사전에 설정해둔 "man1"이 출력됨. 
		
		ctx.close();
	}
	
}
