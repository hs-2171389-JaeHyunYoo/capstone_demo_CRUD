package demoForCapstone.mySelf.dto;

import demoForCapstone.mySelf.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class UserRequestDto {
    private Integer user_id;
    private String user_nickname;

    @Builder
    public UserRequestDto(Integer user_id, String user_nickname) {
        this.user_id = user_id;
        this.user_nickname = user_nickname;
    }

    public User toEntity(){
        return User.builder()
                .id(this.user_id)
                .nickname(this.user_nickname)
                .build();
    }
}
