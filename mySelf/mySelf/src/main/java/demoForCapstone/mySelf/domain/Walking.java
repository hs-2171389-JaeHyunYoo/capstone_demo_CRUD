package demoForCapstone.mySelf.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Walking {
    @Id
    private Integer id;

    @Column
    private Integer distance;

    @Builder
    public Walking(Integer id, Integer distance){
        this.id = id;
        this.distance = distance;
    }

    public void updateWalking(Integer id, Integer distance) {
        this.id = id;
        this.distance = distance;
    }
}
