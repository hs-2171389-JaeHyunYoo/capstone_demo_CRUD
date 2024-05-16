package demoForCapstone.mySelf.controller;

import demoForCapstone.mySelf.domain.User;
import demoForCapstone.mySelf.dto.UserRequestDto;
import demoForCapstone.mySelf.dto.UserResponseDto;
import demoForCapstone.mySelf.repository.UserRepository;
import demoForCapstone.mySelf.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserServiceImpl userService;
    private final UserRepository userRepository;

    @PostMapping("/user/insert")
    public UserResponseDto saevUser(@RequestBody @Validated UserRequestDto request){
        userService.saveUser(request);
        return new UserResponseDto(
                request.toEntity().getUser_id(),
                request.toEntity().getUser_nickname(),
                request.toEntity().getPet_name(),
                request.toEntity().getPet_age(),
                request.toEntity().getUser_introduce(),
                request.toEntity().getUser_follower_count(),
                request.toEntity().getUser_following_count(),
                request.toEntity().getUser_post_count()
        );
    }

    @PutMapping("/user/update/{id}")
    public void updateUser(@PathVariable("id") Integer id,
                                      @RequestBody @Validated UserRequestDto request) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();


            existingUser.setUser_id(request.getUser_id());
            existingUser.setUser_nickname(request.getUser_nickname());
            existingUser.setPet_name(request.getPet_name());
            existingUser.setPet_age(request.getPet_age());
            existingUser.setUser_introduce(request.getUser_introduce());
            existingUser.setUser_follower_count(request.getUser_follower_count());
            existingUser.setUser_following_count(request.getUser_following_count());
            existingUser.setUser_post_count(request.getUser_post_count());


            userRepository.save(existingUser);
        }
        else {
            // ID에 해당하는 댓글이 없는 경우에 대한 처리를 여기에 추가할 수 있습니다.
            // 예를 들어, 예외를 던지거나 로그를 남기는 등의 처리가 가능합니다.
            // 여기에서는 간단히 로그를 출력하도록 합니다.
            System.out.println("유저를 찾을 수 없습니다. ID: " + id);
        }
    }

    @GetMapping("/user/read/{id}")
    public UserResponseDto findUser (@PathVariable("id") Integer id){
        UserRequestDto user = userService.getUser(id);
        return new UserResponseDto(
                user.getUser_id(),
                user.getUser_nickname(),
                user.getPet_name(),
                user.getPet_age(),
                user.getUser_introduce(),
                user.getUser_follower_count(),
                user.getUser_following_count(),
                user.getUser_post_count()
        );
    }

    @GetMapping("/user/readAll")
    public List<UserRequestDto> findAllUser(){
        List<User> findAll = userRepository.findAll();
        List<UserRequestDto> allUser = new ArrayList<>();

        for (User user : findAll) {
            UserRequestDto build = UserRequestDto.builder()
                    .user_id(user.getUser_id())
                    .user_nickname(user.getUser_nickname())
                    .build();
            allUser.add(build);
        }

        return allUser;
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser (@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }

}
