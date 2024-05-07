package demoForCapstone.mySelf.controller;

import demoForCapstone.mySelf.domain.Walking;
import demoForCapstone.mySelf.dto.WalkingRequestDto;
import demoForCapstone.mySelf.dto.WalkingResponseDto;
import demoForCapstone.mySelf.repository.WalkingRepository;
import demoForCapstone.mySelf.service.WalkingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class WalkingApiController {
    private final WalkingServiceImpl walkingService;
    private final WalkingRepository walkingRepository;

    @PostMapping("/walking/insert")
    public WalkingResponseDto saveWalking(@RequestBody @Validated WalkingRequestDto request){
        walkingService.saveWalking(request);

        return new WalkingResponseDto(
                request.toEntity().getId(),
                request.toEntity().getDistance()
        );
    }

    @PutMapping("walking/update/{id}")
    public WalkingResponseDto updateWalking(@PathVariable("id") Integer id,
                                            @RequestBody @Validated WalkingRequestDto request){
        walkingService.updateWalking(id, request);
        Optional<Walking> findWalking = walkingRepository.findById(id);
        Walking walking = findWalking.get();

        return new WalkingResponseDto(
                walking.getId(),
                walking.getDistance()
        );
    }

    @GetMapping("walking/readAll")
    public List<WalkingRequestDto> findAllWalkings(){
        List<Walking> findAll = walkingRepository.findAll();
        List<WalkingRequestDto> allWalking = new ArrayList<>();

        for(Walking walking : findAll){
            WalkingRequestDto build = WalkingRequestDto.builder()
                    .id(walking.getId())
                    .distance(walking.getDistance())
                    .build();

            allWalking.add(build);
        }

        return allWalking;
    }

    @GetMapping("walking/read/{id}")
    public WalkingResponseDto findWalking(@PathVariable("id") Integer id){
        WalkingRequestDto walking = walkingService.getWalking(id);

        return new WalkingResponseDto(
                walking.getId(),
                walking.getDistance()
        );
    }

    @DeleteMapping("/walking/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        walkingService.deleteWalking(id);
    }
}
