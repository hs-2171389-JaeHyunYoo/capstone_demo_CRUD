package demoForCapstone.mySelf.dto;

import demoForCapstone.mySelf.domain.Walking;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class WalkingRequestDto {
    private Integer walking_id;
    private LocalDateTime walking_start;
    private LocalDateTime walking_end;
    private Double walking_distance;
    private Integer walking_calorie;

    @Builder
    public WalkingRequestDto (Integer walking_id, LocalDateTime walking_start, LocalDateTime walking_end, Double walking_distance,
                              Integer walking_calorie) {
        this.walking_id = walking_id;
        this.walking_start = walking_start;
        this.walking_end = walking_end;
        this.walking_distance = walking_distance;
        this.walking_calorie = walking_calorie;
    }

    public Walking toEntity(){
        return Walking.builder()
                .walking_id(this.walking_id)
                .walking_start(this.walking_start)
                .walking_end(this.walking_end)
                .walking_distance(this.walking_distance)
                .walking_calorie(this.walking_calorie)
                .build();
    }
}
