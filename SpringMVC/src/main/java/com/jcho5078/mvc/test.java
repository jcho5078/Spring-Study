package com.jcho5078.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class test {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String run() {
		
		return "test";
	}
}
