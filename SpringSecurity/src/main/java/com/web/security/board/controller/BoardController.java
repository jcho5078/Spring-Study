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
	@RequestMapping("board")
	public String moveBoardList(Model model, BoardVO vo) {
		
		model.addAttribute("boardList", boardService.loadBoard(vo));
		
		return "boardList";
	}
	
	//게시글 작성 페이지로 이동
	@RequestMapping("board/boardinsert")
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
