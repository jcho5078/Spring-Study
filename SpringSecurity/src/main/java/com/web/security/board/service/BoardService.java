package com.web.security.board.service;

import java.util.List;

import com.web.security.board.vo.BoardVO;

public interface BoardService {
	
	public void insertBoard(BoardVO vo);
	public List<BoardVO> loadBoard() throws Exception;
	public BoardVO viewBoard(int bdnum) throws Exception;
}
