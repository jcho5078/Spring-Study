package com.web.security.board.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.security.board.service.BoardService;
import com.web.security.board.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	//게시판 글 리스트 출력
	@RequestMapping(value="board" ,method = RequestMethod.GET)
	public String moveBoardList(Model model) throws Exception {
		
		model.addAttribute("boardList", boardService.loadBoard());
		
		return "boardList";
	}
	
	//게시판 글 조회
	@RequestMapping(value="board/readBoard",method = RequestMethod.GET)
	public String viewBoard(Model model, BoardVO vo) throws Exception {
		
		System.out.println(vo.getBdnum()+"번글 확인");
		model.addAttribute("viewBoard", boardService.viewBoard(vo.getBdnum()));
		
		return "boardView";
	}
	
	//게시글작성으로 이동
	@RequestMapping(value="board/boardinsert")
	public String moveInsertBoardList(Model model, Principal principal) {
		
		String name = principal.getName();
		model.addAttribute("name", name);
		
		return "boardInsertForm";
	}
	
	
	//작성한 게시글 업로드
	@RequestMapping(value="board/boardinsert/insert", method = RequestMethod.POST)
	public String insertBoard(BoardVO vo) {
		
		boardService.insertBoard(vo);
		
		return "redirect:/board";//내가 작성한 글로 이동하도록 수정
	}
}
