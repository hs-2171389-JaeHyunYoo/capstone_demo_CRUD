package demoForCapstone.mySelf.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponseDto {
    private Integer user_id;
    private String user_nickname;

    @Builder
    public UserResponseDto (Integer user_id, String user_nickname){
        this.user_id = user_id;
        this.user_nickname = user_nickname;
    }
}
