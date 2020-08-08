package com.jcho5078.mvc.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("eventForm")
public class EventController {
	
	@RequestMapping("/eventForm")
	public String goForm() {
		return "form";
	}
	
	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String GetData(@ModelAttribute EventVO eventVO, ModelMap model) {
		
		System.out.println("VO값 확인" + eventVO);
		System.out.println("VO의 name 확인" + eventVO.getName());
		System.out.println("VO의 pw 확인" + eventVO.getPw());
		
		model.addAttribute("name", eventVO.getName());
		model.addAttribute("pw", eventVO.getPw());
		
		System.out.println(model);
		
		return "form";
	}
	
	@RequestMapping(value="/event1", method = RequestMethod.POST)
	public String PostData(@ModelAttribute EventVO eventVO, ModelMap model) {
		
		System.out.println("VO값 확인" + eventVO);
		System.out.println("VO의 name 확인" + eventVO.getName());
		System.out.println("VO의 pw 확인" + eventVO.getPw());
		
		model.addAttribute("name", eventVO.getName());
		model.addAttribute("pw", eventVO.getPw());
		
		System.out.println(model);
		
		return "form";//Model을 사용하면서 컨트롤러에서 뷰로 값을 전달할 때에는 해당 jsp를 리턴.
	}
}
