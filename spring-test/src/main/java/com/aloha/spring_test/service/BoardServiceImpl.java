package com.aloha.spring_test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring_test.domain.Board;
import com.aloha.spring_test.domain.Page;
import com.aloha.spring_test.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> list(Page page) throws Exception {
        int total = count();
        page.setTotal(total);
        List<Board> boardList = boardMapper.list(page);
        return boardList;
    }

    @Override
    public Board select(int no) throws Exception {
        Board board = boardMapper.select(no);
        return board;
    }

    @Override
    public int insert(Board board) throws Exception {
        int result = boardMapper.insert(board);
        return result;
    }

    @Override
    public int update(Board board) throws Exception {
        int result = boardMapper.update(board);
        return result;
    }

    @Override
    public int delete(int no) throws Exception {
        int result = boardMapper.delete(no);
        return result;
    }

    @Override
    public int count() throws Exception {
        return boardMapper.count();
    }

}