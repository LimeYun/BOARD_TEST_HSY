package com.aloha.spring_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.spring_test.domain.Board;
import com.aloha.spring_test.domain.Page;
import com.aloha.spring_test.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model, Page page) throws Exception {
        List<Board> boardList = boardService.list(page);
        model.addAttribute("boardList", boardList);
        model.addAttribute("page", page);
        model.addAttribute("rows", page.getRows());
        return "/board/list";
    }

    @GetMapping("/read")
    public String select(@RequestParam("no") int no, Model model) throws Exception {
        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "/board/read";
    }

    @GetMapping("/insert")
    public String insert() {
        return "/board/insert";
    }

    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {
        int result = boardService.insert(board);
        if (result >  0) {
            return "redirect:/board/list";
        }
        return "redirect:/board/insert?error";
    }
    
    @GetMapping("/update")
    public String update(@RequestParam("no") int no, Model model) throws Exception {
        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "/board/update";
    }

    @PostMapping("/update")
    public String updatePro(Board board) throws Exception {
        int result = boardService.update(board);
        if (result > 0) {
            return "redirect:/board/list";
        }
        return "redirect:/board/update?error";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        int result = boardService.delete(no);
        if (result > 0) {
            return "redirect:/board/list";
        }
        return "redirect:/board/delete?error";
    }
    
}
