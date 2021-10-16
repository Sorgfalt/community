package com.example.community.controller;

import com.example.community.dto.BoardDto;
import com.example.community.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {
	private BoardService boardService;

	@Autowired
	public void BoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/main")
	public String list(Model model){
		List<BoardDto> boardDtoList = boardService.getBoardList();
		model.addAttribute("boardList",boardDtoList);

		return "board/list.html";
	}

	@GetMapping("/post")
	public String write(){
		return "board/createBoard.html";
	}

	@PostMapping("/post")
	public String write(BoardDto boardDto){
		boardService.savePost(boardDto);

		return "board/list.html";
	}
}
