package demoForCapstone.mySelf.dto;

import demoForCapstone.mySelf.domain.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class BoardRequestDto {

    private Long id;
    private String writer;
    private String title;
    private String content;

    @Builder
    public BoardRequestDto(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

//    @Builder BoardRequestDto(Long id, String writer, String title, String content){
//        this.id = id;
//        this.writer = writer;
//        this.title = title;
//        this.content = content;
//    }

    public Board ToEntity(){
        return Board.builder()
                .writer(this.writer)
                .title(this.title)
                .content(this.content)
                .build();
    }
}
