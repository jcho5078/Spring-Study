package com.web.security.board.dao;

import java.util.List;
import java.util.Map;

import com.web.security.board.vo.BoardVO;

public interface BoardDAO {
	
	public void insertBoard(BoardVO vo);
	public List<BoardVO> loadBoard() throws Exception;
	public BoardVO viewBoard(int bdnum) throws Exception;
}
