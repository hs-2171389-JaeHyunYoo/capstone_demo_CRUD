package demoForCapstone.mySelf.service;

import demoForCapstone.mySelf.domain.User;
import demoForCapstone.mySelf.dto.UserRequestDto;
import demoForCapstone.mySelf.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        userRepository.save(userRequestDto.toEntity());
    }

    @Transactional
    @Override
    public List<UserRequestDto> getAllUser() {
        List<User> all = userRepository.findAll();
        List<UserRequestDto> userRequestDtoList = new ArrayList<>();

        for(User user : all){
            UserRequestDto userDto = UserRequestDto.builder()
                    .user_id(user.getUser_id())
                    .user_nickname(user.getUser_nickname())
                    .build();

            userRequestDtoList.add(userDto);
        }

        return userRequestDtoList;
    }

    @Transactional
    @Override
    public UserRequestDto getUser(Integer id) {
        Optional<User> userWrapper = userRepository.findById(id);
        User user = userWrapper.get();

        return UserRequestDto.builder()
                .user_id(user.getUser_id())
                .user_nickname(user.getUser_nickname())
                .build();
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateUser(Integer id, UserRequestDto userRequestDto) {
        Optional<User> byId = userRepository.findById(id);
        User user = byId.get();

        user.updateUser(userRequestDto.getUser_id(), userRequestDto.getUser_nickname());
    }
}
