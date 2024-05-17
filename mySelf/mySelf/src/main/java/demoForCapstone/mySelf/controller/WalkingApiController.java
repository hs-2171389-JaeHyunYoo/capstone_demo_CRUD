package demoForCapstone.mySelf.controller;

import demoForCapstone.mySelf.domain.Walking;
import demoForCapstone.mySelf.dto.CommentRequestDto;
import demoForCapstone.mySelf.dto.CommentResponseDto;
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
    public WalkingResponseDto saveWalking(@RequestBody @Validated WalkingRequestDto request) {
        walkingService.saveWalking(request);

        return new WalkingResponseDto(
                request.toEntity().getWalking_id(),
                request.toEntity().getWalking_start(),
                request.toEntity().getWalking_end(),
                request.toEntity().getWalking_distance(),
                request.toEntity().getWalking_calorie()
        );
    }

    @PutMapping("/walking/update/{id}")
    public void updateWalking(@PathVariable("id") Integer id,
                                            @RequestBody @Validated WalkingRequestDto request) {
        Optional<Walking> optionalWalking = walkingRepository.findById(id);

        if(optionalWalking.isPresent()){
            Walking existingWalking = optionalWalking.get();

            existingWalking.setWalking_id(request.getWalking_id());
            existingWalking.setWalking_start(request.getWalking_start());
            existingWalking.setWalking_end(request.getWalking_end());
            existingWalking.setWalking_distance(request.getWalking_distance());
            existingWalking.setWalking_calorie(request.getWalking_calorie());

            walkingRepository.save(existingWalking);
        }
        else{
            System.out.println("산책 정보를 찾을 수 없습니다. ID : " + id);
        }
    }

    @GetMapping("/walking/readAll")
    public List<WalkingRequestDto> findAllWalking(){
        List<Walking> findAll = walkingRepository.findAll();
        List<WalkingRequestDto> allWalking = new ArrayList<>();

        for (Walking walking : findAll) {
            WalkingRequestDto build = WalkingRequestDto.builder()
                    .walking_id(walking.getWalking_id())
                    .walking_start(walking.getWalking_start())
                    .walking_end(walking.getWalking_end())
                    .walking_distance(walking.getWalking_distance())
                    .walking_calorie(walking.getWalking_calorie())
                    .build();

            allWalking.add(build);
        }

        return allWalking;
    }


    @GetMapping("/walking/read/{id}")
    public WalkingResponseDto findWalking(@PathVariable("id") Integer id) {
        WalkingRequestDto walking = walkingService.getWalking(id);

        return new WalkingResponseDto(
                walking.getWalking_id(),
                walking.getWalking_start(),
                walking.getWalking_end(),
                walking.getWalking_distance(),
                walking.getWalking_calorie()
        );
    }

    @DeleteMapping("/walking/delete/{id}")
    public void deleteWalking(@PathVariable("id") Integer id){
        walkingService.deleteWalking(id);
    }
}
