package demoForCapstone.mySelf.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalkingResponseDto {
    private Integer id;
    private Integer distance;

    @Builder
    public WalkingResponseDto(Integer id, Integer distance){
        this.id = id;
        this.distance = distance;
    }
}
