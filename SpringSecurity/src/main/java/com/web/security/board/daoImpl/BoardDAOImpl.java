package com.web.security.board.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.security.board.dao.BoardDAO;
import com.web.security.board.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	//게시판 목록 생성
	@Override
	public List<BoardVO> loadBoard() throws Exception {
	
		return sqlSession.selectList("board.loadBoard");
	}
	
	//게시판 글 작성
	@Override
	public void insertBoard(BoardVO vo) {
		
		sqlSession.insert("board.insertBoard", vo);
	}

	@Override
	public BoardVO viewBoard(int bdnum) throws Exception {
		
		return sqlSession.selectOne("board.viewBoard", bdnum);
	}

}
