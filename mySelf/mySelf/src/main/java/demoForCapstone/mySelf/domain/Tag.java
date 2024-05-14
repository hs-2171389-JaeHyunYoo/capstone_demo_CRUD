package demoForCapstone.mySelf.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {
    @Id
    @GeneratedValue
    @Column(name = "tag_id")
    Integer tag_id;

    @Column(name = "tag_name")
    String tag_name;

    @Builder
    public Tag(Integer tag_id, String tag_name){
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }

    public void updateTag(Integer tagId, String tagName) {
    }
}
