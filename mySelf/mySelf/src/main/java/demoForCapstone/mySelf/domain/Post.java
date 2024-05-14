package demoForCapstone.mySelf.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Entity
@Setter
public class Post {
    @Id
    @GeneratedValue
    @Column (name = "post_id")
    Integer post_id;

    @Column (name = "post_writer")
    String post_writer;

    @Column (name = "post_title")
    String post_title;

    @Column (name = "post_content")
    String post_content;

//    @Column (name = "post_likes")
//    Integer post_likes=0;

    @Builder
    public Post (Integer post_id, String post_writer, String post_title, String post_content) {
        this.post_id = post_id;
        this.post_writer = post_writer;
        this.post_title = post_title;
        this.post_content = post_content;
    }

    public void updateComment(Integer postId, String postWriter, String postTitle, String postContent) {
    }
}
