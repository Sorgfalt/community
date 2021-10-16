package com.example.community.service;

import com.example.community.domain.entity.Board;
import com.example.community.dto.BoardDto;
import com.example.community.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class BoardService {
	private BoardRepository boardRepository;

	public BoardService(BoardRepository boardRepository){
		this.boardRepository = boardRepository;
	}

	@Transactional
	public Long savePost(BoardDto boardDto){
		return boardRepository.save(boardDto.toEntity()).getId();
	}

	@Transactional
	public List<BoardDto> getBoardList() {
		List<Board> boards = boardRepository.findAll();
		List<BoardDto> boardDtoList = new ArrayList<>();

		for(Board board : boards) {
			BoardDto boardDto = BoardDto.builder()
				.id(board.getId())
					.title(board.getTitle())
					.content(board.getContent())
					.writer(board.getWriter())
					.build();
			boardDtoList.add(boardDto);
		}

		return  boardDtoList;
	}
}
