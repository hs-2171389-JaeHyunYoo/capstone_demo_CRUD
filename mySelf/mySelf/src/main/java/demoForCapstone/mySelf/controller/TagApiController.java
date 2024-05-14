package demoForCapstone.mySelf.controller;

import demoForCapstone.mySelf.domain.Tag;
import demoForCapstone.mySelf.dto.TagRequestDto;
import demoForCapstone.mySelf.dto.TagResponseDto;
import demoForCapstone.mySelf.repository.TagRepository;
import demoForCapstone.mySelf.service.TagServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TagApiController {
    private final TagServiceImpl tagService;
    private final TagRepository tagRepository;

    @PostMapping("/tag/insert")
    public TagResponseDto saveTag(@RequestBody @Validated TagRequestDto request){
        tagService.saveTag(request);
        return new TagResponseDto(
                request.toEntity().getTag_id(),
                request.toEntity().getTag_name()
        );
    }

    @PutMapping("/tag/update/{id}")
    public TagResponseDto updateTag(@PathVariable("id") Integer id,
                                    @RequestBody @Validated TagRequestDto request) {
        tagService.updateTag(id, request);

        Optional<Tag> findTag = tagRepository.findById(id);
        Tag tag = findTag.get();

        return new TagResponseDto(
                tag.getTag_id(),
                tag.getTag_name()
        );
    }


    @GetMapping("/tag/readAll")
    public List<TagRequestDto> findAllTags(){
        List<Tag> findAll = tagRepository.findAll();
        List<TagRequestDto> allTags = new ArrayList<>();

        for (Tag tag : findAll) {
            TagRequestDto build = TagRequestDto.builder()
                    .tag_id(tag.getTag_id())
                    .tag_name(tag.getTag_name())
                    .build();

            allTags.add(build);
        }
        return allTags;
    }

    @GetMapping("/tag/read/{id}")
    public TagResponseDto findTag(@PathVariable("id") Integer id){
        TagRequestDto tag = tagService.getTag(id);

        return new TagResponseDto(
                tag.getTag_id(),
                tag.getTag_name()
        );
    }

    @DeleteMapping("/tag/delete/{id}")
    public void deleteTag(@PathVariable("id") Integer id) {
        tagService.deleteTag(id);
    }
}
