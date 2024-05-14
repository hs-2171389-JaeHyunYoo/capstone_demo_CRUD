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
                request.toEntity().getUser_nickname()
        );
    }

    @PutMapping("/user/update/{id}")
    public UserResponseDto updateUser(@PathVariable("id") Integer id,
                                      @RequestBody @Validated UserRequestDto request) {
        userService.updateUser(id, request);
        Optional<User> findUser = userRepository.findById(id);
        User user = findUser.get();

        return new UserResponseDto(
                user.getUser_id(),
                user.getUser_nickname()
        );
    }

    @GetMapping("/user/read/{id}")
    public UserResponseDto findUser (@PathVariable("id") Integer id){
        UserRequestDto user = userService.getUser(id);
        return new UserResponseDto(
                user.getUser_id(),
                user.getUser_nickname()
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
