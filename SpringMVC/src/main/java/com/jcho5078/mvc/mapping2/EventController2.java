package com.jcho5078.mvc.mapping2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("eventForm2")
public class EventController2 {
	
	@RequestMapping("/eventForm2")
	public String goForm() {
		return "form2";
	}
	
	@RequestMapping(value = "/event2", method = RequestMethod.POST)
	public String GetData(@ModelAttribute("vo") EventVO2 eventVO, ModelMap model) {
		
		System.out.println("VO값 확인" + eventVO);
		System.out.println("VO의 name 확인" + eventVO.getName());
		System.out.println("VO의 pw 확인" + eventVO.getPw());
		
		model.addAttribute("name", eventVO.getName());
		model.addAttribute("pw", eventVO.getPw());
		
		System.out.println(model);
		
		return "form2";
	}
	
	@RequestMapping(value="/event3", method = RequestMethod.POST)
	public String PostData(@ModelAttribute("vv") EventVO2 eventVO, ModelMap model) {
		
		System.out.println("VO값 확인" + eventVO);
		System.out.println("VO의 name 확인" + eventVO.getName());
		System.out.println("VO의 pw 확인" + eventVO.getPw());
		
		model.addAttribute("name", eventVO.getName());
		model.addAttribute("pw", eventVO.getPw());
		
		System.out.println(model);
			
		return "form2";//Model을 사용하면서 컨트롤러에서 뷰로 값을 전달할 때에는 해당 jsp를 리턴.
	}
}
