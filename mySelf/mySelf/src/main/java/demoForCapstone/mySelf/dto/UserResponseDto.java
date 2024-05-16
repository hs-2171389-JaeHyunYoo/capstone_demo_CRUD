package demoForCapstone.mySelf.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponseDto {
    private Integer user_id;
    private String user_nickname;
    private String pet_name;
    private Integer pet_age;
    private String user_introduce;
    private Integer user_follower_count;
    private Integer user_following_count;
    private Integer user_post_count;

    @Builder
    public UserResponseDto (Integer user_id, String user_nickname, String pet_name, Integer pet_age, String user_introduce,
                            Integer user_follower_count, Integer user_following_count, Integer user_post_count){
        this.user_id = user_id;
        this.user_nickname = user_nickname;
        this.pet_name = pet_name;
        this.pet_age = pet_age;
        this.user_introduce = user_introduce;
        this.user_follower_count = user_follower_count;
        this.user_following_count = user_following_count;
        this.user_post_count = user_post_count;
    }
}
