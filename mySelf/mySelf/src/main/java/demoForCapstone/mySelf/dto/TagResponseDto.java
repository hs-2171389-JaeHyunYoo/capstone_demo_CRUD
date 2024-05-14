package demoForCapstone.mySelf.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagResponseDto {
    private Integer tag_id;
    private String tag_name;

    @Builder
    public TagResponseDto (Integer tag_id, String tag_name){
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }
}
