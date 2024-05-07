package demoForCapstone.mySelf.dto;

import demoForCapstone.mySelf.domain.Walking;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WalkingRequestDto {
    private Integer id;
    private Integer distance;

    @Builder
    public WalkingRequestDto(Integer id, Integer distance){
        this.id = id;
        this.distance = distance;
    }

    public Walking toEntity(){
        return Walking.builder()
                .id(this.id)
                .distance(this.distance)
                .build();
    }
}
