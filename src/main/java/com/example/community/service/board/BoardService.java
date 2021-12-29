package com.example.community.service.board;

import com.example.community.domain.entity.board.Board;
import com.example.community.dto.board.BoardDto;
import com.example.community.repository.board.BoardRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
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
					.createdDate(board.getCreatedDate())
					.build();
			boardDtoList.add(boardDto);
		}
		return  boardDtoList;
	}

	@Transactional
	public BoardDto getPost(Long id){
		Optional<Board> boardEntityWrapper = boardRepository.findById(id);
		Board board = boardEntityWrapper.get();

		BoardDto boardDto = BoardDto.builder()
				.id(board.getId())
				.title(board.getTitle())
				.content(board.getContent())
				.writer(board.getWriter())
				.createdDate(board.getCreatedDate())
				.build();
			return boardDto;
	}

	@Transactional
	public void deletePost(Long id){
		boardRepository.deleteById(id);
	}
}
