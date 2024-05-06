package demoForCapstone.mySelf.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String writer;
    private String title;
    private String content;

    @Builder
    public BoardResponseDto(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
