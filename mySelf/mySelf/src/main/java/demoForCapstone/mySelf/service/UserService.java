package demoForCapstone.mySelf.service;



import demoForCapstone.mySelf.dto.UserRequestDto;

import java.util.List;

public interface UserService {
    public void saveUser(UserRequestDto userRequestDto); //User 저장

    public List<UserRequestDto> getAllUser(); //모든 User 가져오기

    public UserRequestDto getUser(Integer id); //id로 User 검색

    public void deleteUser(Integer id); //id로 User 삭제

    public void updateUser(Integer id, UserRequestDto userRequestDto); //User 정보 변경
}
