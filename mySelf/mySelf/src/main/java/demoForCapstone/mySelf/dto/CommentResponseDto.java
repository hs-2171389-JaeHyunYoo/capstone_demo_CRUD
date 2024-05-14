package demoForCapstone.mySelf.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentResponseDto {
    private Integer comment_id;
    private String comment_writer;
    private String comment_content;

    @Builder
    public CommentResponseDto (Integer comment_id, String comment_writer, String comment_content){
        this.comment_id = comment_id;
        this.comment_writer = comment_writer;
        this.comment_content = comment_content;
    }
}
