package demoForCapstone.mySelf.domain;

import jakarta.persistence.*;
import lombok.*;

import java.awt.image.ImagingOpException;

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

    @Column (name = "pet_name")
    String pet_name;

    @Column (name = "pet_age")
    Integer pet_age;

    @Column (name = "user_introduce")
    String user_introduce;

    @Column (name = "user_follower_count")
    Integer user_follower_count;

    @Column (name =  "user_following_count")
    Integer user_following_count;

    @Column (name = "user_post_count")
    Integer user_post_count;


    @Builder
    public User (Integer id, String nickname, String pet_name, Integer pet_age, String user_introduce, Integer user_follower_count,
        Integer user_following_count, Integer user_post_count) {
        this.user_id = id;
        this.user_nickname = nickname;
        this.pet_name = pet_name;
        this.pet_age = pet_age;
        this.user_introduce = user_introduce;
        this.user_follower_count = user_follower_count;
        this.user_following_count = user_following_count;
        this.user_post_count = user_post_count;
    }

    public void updateUser(Integer userId, String userNickname) {
    }
}
