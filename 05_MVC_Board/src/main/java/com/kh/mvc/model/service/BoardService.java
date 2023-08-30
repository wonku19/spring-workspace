package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.mvc.model.dao.BoardDAO;
import com.kh.mvc.model.vo.Board;

@Service
public class BoardService {
	
	@Autowired
    private BoardDAO dao;

    @Transactional
    public int insertBoard(Board board) {
        return dao.insertBoard(board);
    }

    public List<Board> selectAllBoard() {
        return dao.selectAllBoard();
    }

    public Board selectBoard(int no) {
        return dao.selectBoard(no);
    }

    @Transactional
    public int updateBoard(Board board) {
        return dao.updateBoard(board);
    }

    @Transactional
    public int deleteBoard(int no) {
        return dao.deleteBoard(no);
    }
}
