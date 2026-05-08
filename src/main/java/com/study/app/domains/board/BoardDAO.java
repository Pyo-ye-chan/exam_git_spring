package com.study.app.domains.board;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public List<BoardDTO> selectAll() {
		return mybatis.selectList("Board.selectAll");
	}

	@Transactional
	public BoardDTO selectBySeq(String seq) {
		mybatis.update("Board.updateViewCount", seq);
		return mybatis.selectOne("Board.selectBySeq", seq);
	}

	public void insert(BoardDTO board) {
		mybatis.insert("Board.insert", board);
	}

	public void update(BoardDTO board) {
		mybatis.update("Board.update", board);
	}

	public void delete(String seq) {
		mybatis.delete("Board.delete", seq);
	}


}
