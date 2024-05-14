package demoForCapstone.mySelf.dto;

import demoForCapstone.mySelf.domain.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TagRequestDto {
    private Integer tag_id;
    private String tag_name;

    @Builder
    public TagRequestDto (Integer tag_id, String tag_name) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }

    public Tag toEntity(){
        return Tag.builder()
                .tag_id(this.tag_id)
                .tag_name(this.tag_name)
                .build();
    }
}
