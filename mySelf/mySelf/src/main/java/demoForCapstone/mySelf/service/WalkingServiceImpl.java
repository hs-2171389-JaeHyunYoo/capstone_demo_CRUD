package demoForCapstone.mySelf.service;

import demoForCapstone.mySelf.domain.Walking;
import demoForCapstone.mySelf.dto.WalkingRequestDto;
import demoForCapstone.mySelf.repository.WalkingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalkingServiceImpl implements WalkingService{
    private final WalkingRepository walkingRepository;

    @Transactional
    @Override
    public void saveWalking(WalkingRequestDto walkingRequestDto) {
        walkingRepository.save(walkingRequestDto.toEntity());
    }
    @Transactional
    @Override
    public List<WalkingRequestDto> getAllWalking() {
        List<Walking> all = walkingRepository.findAll();
        List<WalkingRequestDto> walkingRequestDtoList = new ArrayList<>();

        for (Walking walking : all) {
            WalkingRequestDto walkingDto = WalkingRequestDto.builder()
                    .walking_id(walking.getWalking_id())
                    .walking_start(walking.getWalking_start())
                    .walking_end(walking.getWalking_end())
                    .walking_distance(walking.getWalking_distance())
                    .walking_calorie(walking.getWalking_calorie())
                    .build();

            walkingRequestDtoList.add(walkingDto);
        }

        return walkingRequestDtoList;
    }
    @Transactional
    @Override
    public WalkingRequestDto getWalking(Integer id) {
        Optional<Walking> walkingWrapper = walkingRepository.findById(id);
        Walking walking = walkingWrapper.get();

        return WalkingRequestDto.builder()
                .walking_id(walking.getWalking_id())
                .walking_start(walking.getWalking_start())
                .walking_end(walking.getWalking_end())
                .walking_distance(walking.getWalking_distance())
                .walking_calorie(walking.getWalking_calorie())
                .build();
    }
    @Transactional
    @Override
    public void deleteWalking(Integer id) {
        walkingRepository.deleteById(id);
    }
    @Transactional
    @Override
    public void updateWalking(Integer id, WalkingRequestDto walkingRequestDto) {
        Optional<Walking> optionalWalking = walkingRepository.findById(id);

        if (optionalWalking.isPresent()) {
            Walking existingWalking = optionalWalking.get();

            existingWalking.setWalking_id(walkingRequestDto.getWalking_id());
            existingWalking.setWalking_start(walkingRequestDto.getWalking_start());
            existingWalking.setWalking_end(walkingRequestDto.getWalking_end());
            existingWalking.setWalking_distance(walkingRequestDto.getWalking_distance());
            existingWalking.setWalking_calorie(walkingRequestDto.getWalking_calorie());

            walkingRepository.save(existingWalking);
        } else {
            System.out.println("산책 정보를 찾을 수 없습니다. ID: " + id);
        }
    }
}
