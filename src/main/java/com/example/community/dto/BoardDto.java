package com.example.community.dto;

import com.example.community.domain.entity.Board;
import lombok.Builder;

public class BoardDto {
	private final Long id;
	private final String writer;
	private final String title;
	private final String content;

	public Board toEntity(){
		return Board.builder()
				.id(id)
				.writer(writer)
				.title(title)
				.content(content)
				.build();
	}

	@Builder
	public BoardDto(Long id, String title, String content, String writer) {
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
}
