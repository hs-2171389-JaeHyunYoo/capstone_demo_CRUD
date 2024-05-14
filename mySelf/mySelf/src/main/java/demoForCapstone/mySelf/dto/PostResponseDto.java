package demoForCapstone.mySelf.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostResponseDto {
    private Integer post_id;
    private String post_writer;
    private String post_title;
    private String post_content;


    @Builder
    public PostResponseDto (Integer post_id, String post_writer, String post_title, String post_content) {
        this.post_id = post_id;
        this.post_writer = post_writer;
        this.post_title = post_title;
        this.post_content = post_content;
    }
}
