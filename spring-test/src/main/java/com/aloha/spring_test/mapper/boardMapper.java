package com.aloha.spring_test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aloha.spring_test.domain.Board;
import com.aloha.spring_test.domain.Page;

@Mapper
public interface BoardMapper {

    public List<Board> list(@Param("page") Page page) throws Exception;

    public Board select(int no) throws Exception;

    public int insert(Board board) throws Exception;

    public int update(Board board) throws Exception;
    
    public int delete(int no) throws Exception;
    
    public int count() throws Exception; 
}
