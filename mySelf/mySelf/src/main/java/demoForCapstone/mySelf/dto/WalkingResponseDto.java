package demoForCapstone.mySelf.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class WalkingResponseDto {
    private Integer walking_id;
    private LocalDateTime walking_start;
    private LocalDateTime walking_end;
    private Double walking_distance;
    private Integer walking_calorie;

    @Builder
    public WalkingResponseDto (Integer walking_id, LocalDateTime walking_start, LocalDateTime walking_end,
                               Double walking_distance, Integer walking_calorie) {
        this.walking_id = walking_id;
        this.walking_start = walking_start;
        this.walking_end = walking_end;
        this.walking_distance = walking_distance;
        this.walking_calorie = walking_calorie;
    }
}
