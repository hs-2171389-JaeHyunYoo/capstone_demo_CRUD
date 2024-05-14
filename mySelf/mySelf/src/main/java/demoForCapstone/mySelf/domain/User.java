package demoForCapstone.mySelf.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    Integer user_id;

    @Column (length = 50, nullable = false, name = "user_nickname")
    String user_nickname;


    @Builder
    public User (Integer id, String nickname){
        this.user_id = id;
        this.user_nickname = nickname;
    }

    public void updateUser(Integer userId, String userNickname) {
    }
}
