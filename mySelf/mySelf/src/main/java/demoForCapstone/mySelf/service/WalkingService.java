package demoForCapstone.mySelf.service;

import demoForCapstone.mySelf.dto.WalkingRequestDto;

import java.util.List;

public interface WalkingService {
    public void saveWalking(WalkingRequestDto walkingRequestDto); //산책 정보 저장

    public List<WalkingRequestDto> getAllWalking(); //모든 산책 정보 가져오기

    public WalkingRequestDto getWalking(Integer id); //특정 산책 정보 가져오기 by id

    public void deleteWalking(Integer id); //특정 산책 정보 지우기 by id

    public void updateWalking(Integer id, WalkingRequestDto walkingRequestDto); //특정 산책 정보 수정

}
