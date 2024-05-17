package demoForCapstone.mySelf.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Walking {
    @Id
    @GeneratedValue
    @Column (name = "walking_id")
    private Integer walking_id;

    @Column (name = "walking_start")
    private LocalDateTime walking_start;

    @Column (name = "walking_stop")
    private LocalDateTime walking_end;

    @Column (name = "walking_distance")
    private Double walking_distance;

    @Column (name = "walking_calorie")
    private Integer walking_calorie;

    @Builder
    public Walking(Integer walking_id, LocalDateTime walking_start, LocalDateTime walking_end, Double walking_distance,
                   Integer walking_calorie){
        this.walking_id = walking_id;
        this.walking_start = walking_start;
        this.walking_end = walking_end;
        this.walking_distance = walking_distance;
        this.walking_calorie = walking_calorie;
    }

}
