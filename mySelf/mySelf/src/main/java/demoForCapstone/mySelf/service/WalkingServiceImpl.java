package demoForCapstone.mySelf.service;

import demoForCapstone.mySelf.domain.Board;
import demoForCapstone.mySelf.domain.Walking;
import demoForCapstone.mySelf.dto.BoardRequestDto;
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
public class WalkingServiceImpl implements WalkingService {
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
        List<WalkingRequestDto> walkingDtoList = new ArrayList<>();

        for(Walking walking : all){
            WalkingRequestDto walkingDto = WalkingRequestDto.builder()
                    .id(walking.getId())
                    .distance(walking.getDistance())
                    .build();

            walkingDtoList.add(walkingDto);
        }

        return walkingDtoList;
    }

    @Transactional
    @Override
    public WalkingRequestDto getWalking(Integer id) {
        Optional<Walking> walkingWrapper = walkingRepository.findById(id);
        Walking walking = walkingWrapper.get();

        return WalkingRequestDto.builder()
                .id(walking.getId())
                .distance(walking.getDistance())
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
        Optional<Walking> byId = walkingRepository.findById(id);
        Walking walking = byId.get();

        walking.updateWalking(walkingRequestDto.getId(), walkingRequestDto.getDistance());
    }
}
