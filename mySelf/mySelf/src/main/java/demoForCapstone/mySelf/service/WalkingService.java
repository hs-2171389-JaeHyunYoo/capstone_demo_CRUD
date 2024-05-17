package demoForCapstone.mySelf.service;


import demoForCapstone.mySelf.dto.WalkingRequestDto;

import java.util.List;

public interface WalkingService {
    public void saveWalking(WalkingRequestDto walkingRequestDto);

    public List<WalkingRequestDto> getAllWalking();

    public WalkingRequestDto getWalking(Integer id);

    public void deleteWalking(Integer id);

    public void updateWalking(Integer id, WalkingRequestDto walkingRequestDto);
}
