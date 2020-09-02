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
	public List<BoardVO> loadBoard() throws Exception {
		
		return boardDAO.loadBoard();
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		
		boardDAO.insertBoard(vo);
	}

	@Override
	public BoardVO viewBoard(int bdnum) throws Exception {
		
		return boardDAO.viewBoard(bdnum);
	}
	
}
