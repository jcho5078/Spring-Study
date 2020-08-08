package com.jcho5078.mvc.session;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jcho5078.mvc.session.EventVO;

@Controller
@SessionAttributes("session")
public class SessionController {
	
	@RequestMapping(value = "/sessionForm", method = RequestMethod.GET)
	public String run1(Model model) {
		model.addAttribute("session", new EventVO());
		//새로운 세션 할당하며 "session"이라 이름을 지정한 세션에 클래스 타입 지정. 
        //어떠한 페이지에 가도 "session" 이란 이름으로 해당 객체값 저장되어 있음.
		return "sessionForm";
	}
	
	@RequestMapping(value = "/sessionForm2", method = RequestMethod.GET)
	public String run2(@ModelAttribute("session") EventVO eventVO, HttpSession session) {
		EventVO eventVO2 = (EventVO) session.getAttribute("session");//세션 객체를 하나 더 생성해 지정한 타입의 클래스에 새로 생성한 세션객체를 대입 후, 같은 값을 가지는지 확인.
		System.out.println("VO값 확인" + eventVO);
		System.out.println("VO값 확인 " + eventVO2);
		return "sessionForm";
	}
}
