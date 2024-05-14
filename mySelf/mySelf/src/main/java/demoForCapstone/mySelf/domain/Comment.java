package demoForCapstone.mySelf.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Entity
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    Integer comment_id;

    @Column(name = "comment_writer")
    String comment_writer;

    @Column(name = "comment_content")
    String comment_content;

    @Builder
    public Comment (Integer comment_id, String comment_writer, String comment_content) {
        this.comment_id = comment_id;
        this.comment_writer = comment_writer;
        this.comment_content = comment_content;
    }

    public void updateComment(Integer commentId, String commentWriter, String commentContent) {
    }
}
