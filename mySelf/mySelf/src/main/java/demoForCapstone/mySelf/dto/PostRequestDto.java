package demoForCapstone.mySelf.dto;

import demoForCapstone.mySelf.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostRequestDto {
    private Integer post_id;
    private String post_writer;
    private String post_title;
    private String post_content;


    @Builder
    public PostRequestDto (Integer post_id, String post_writer, String post_title, String post_content) {
        this.post_id = post_id;
        this.post_writer = post_writer;
        this.post_title = post_title;
        this.post_content = post_content;
    }

    public Post toEntity(){
        return Post.builder()
                .post_id(this.post_id)
                .post_writer(this.post_writer)
                .post_title(this.post_title)
                .post_content(this.post_content)
                .build();
    }
}
