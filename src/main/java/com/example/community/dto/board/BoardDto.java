package com.example.community.dto.board;

import com.example.community.domain.entity.board.Board;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
	private Long id;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;

	public Board toEntity(){
		return Board.builder()
				.id(id)
				.writer(writer)
				.title(title)
				.content(content)
				.build();
	}

	@Builder
	public BoardDto(Long id, String title, String content, String writer, LocalDateTime createdDate, LocalDateTime modifiedDate) {
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
}
