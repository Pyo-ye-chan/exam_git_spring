package com.study.app.domains.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService { 
	
	@Autowired
    private BoardDAO boardDAO;


    public List<BoardDTO> getBoardList() {
        return boardDAO.selectAll();
    }

    @Transactional
    public BoardDTO getBoard(String seq) {
        return boardDAO.selectBySeq(seq);
    }

    public void registerBoard(BoardDTO board) {
        boardDAO.insert(board);
    }

    public void modifyBoard(BoardDTO board) {
        boardDAO.update(board);
    }

    public void removeBoard(String seq) {
        boardDAO.delete(seq);
    }
}
