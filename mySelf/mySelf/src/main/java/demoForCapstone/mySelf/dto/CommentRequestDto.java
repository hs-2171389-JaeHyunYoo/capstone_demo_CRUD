package demoForCapstone.mySelf.dto;

import demoForCapstone.mySelf.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private Integer comment_id;
    private String comment_writer;
    private String comment_content;

    @Builder
    public CommentRequestDto (Integer comment_id, String comment_writer, String comment_content){
        this.comment_id = comment_id;
        this.comment_writer = comment_writer;
        this.comment_content = comment_content;
    }

    public Comment toEntity(){
        return Comment.builder()
                .comment_id(this.comment_id)
                .comment_writer(this.comment_writer)
                .comment_content(this.comment_content)
                .build();
    }
}
