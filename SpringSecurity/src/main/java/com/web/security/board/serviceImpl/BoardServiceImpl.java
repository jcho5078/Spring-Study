package com.web.security.board.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.security.board.dao.BoardDAO;
import com.web.security.board.service.BoardService;
import com.web.security.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> loadBoard(BoardVO vo) {
		
		return boardDAO.loadBoard(vo);
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		
		boardDAO.insertBoard(vo);
	}
	
}
