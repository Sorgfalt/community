package com.example.community.controller;

import com.example.community.dto.BoardDto;
import com.example.community.service.BoardService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
public class BoardController {
	private BoardService boardService;

	@Autowired
	public void BoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/main")
	public String list(Model model){
		List<BoardDto> boardDtoList = boardService.getBoardList();
		model.addAttribute("boardList",boardDtoList);

		return "board/list";
	}

	@GetMapping("/post")
	public String write(){

		return "board/createBoard";
	}

	@PostMapping("/post")
	public String write(BoardDto boardDto){
		boardService.savePost(boardDto);

		return "redirect:/main";
	}

	@GetMapping("/post/{no}")
	public String detail(@PathVariable("no") Long no, Model model) {
		BoardDto boardDto = boardService.getPost(no);

		model.addAttribute("boardDto", boardDto);
		return "board/detailBoard";
	}

	@GetMapping("/post/edit/{no}")
	public String edit(@PathVariable("no") Long no, Model model) {
		BoardDto boardDto = boardService.getPost(no);

		model.addAttribute("boardDto", boardDto);
		return "board/updateBoard";
	}

	@PutMapping("/post/edit/{no}")
	public String update(BoardDto boardDto) {
		boardService.savePost(boardDto);

		return "redirect:/main";
	}

	@DeleteMapping("post/{no}")
	public String delete(@PathVariable("no") Long no) {
		boardService.deletePost(no);

		return "redirect:/main";
	}

}
