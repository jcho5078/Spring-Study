package com.jcho5078.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BordNum {
	
	Integer[] array = {0, 1};//bord.jsp 하나에 페이지 두 개 생성
	
	@RequestMapping("/board/{id}")//매핑 url은 /board
	public String bordNum(@PathVariable Integer id, Model model) {
		
		for(Integer temp : array) {
			id = temp;
		}
		try {
			return "board/board";//board폴더의 "board" 와 dispatcherServlet에서 설정된 .jsp 합친 경로에 페이지 이동.
			
		}catch (Exception e) {
			e.printStackTrace();
			return "home";
		}
	}
}
