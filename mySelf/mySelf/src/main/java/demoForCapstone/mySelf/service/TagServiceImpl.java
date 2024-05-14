package demoForCapstone.mySelf.service;

import demoForCapstone.mySelf.domain.Tag;
import demoForCapstone.mySelf.dto.TagRequestDto;
import demoForCapstone.mySelf.repository.TagRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService{
    private final TagRepository tagRepository;
    @Transactional
    @Override
    public void saveTag(TagRequestDto tagRequestDto) {
        tagRepository.save(tagRequestDto.toEntity());
    }

    @Transactional
    @Override
    public List<TagRequestDto> getAllTags() {
        List<Tag> all = tagRepository.findAll();
        List<TagRequestDto> tagRequestDtoList = new ArrayList<>();

        for (Tag tag : all){
            TagRequestDto tagDto = TagRequestDto.builder()
                    .tag_id(tag.getTag_id())
                    .tag_name(tag.getTag_name())
                    .build();

            tagRequestDtoList.add(tagDto);
        }
        return tagRequestDtoList;
    }

    @Transactional
    @Override
    public TagRequestDto getTag(Integer id) {
        Optional<Tag> tagWrapper = tagRepository.findById(id);
        Tag tag = tagWrapper.get();

        return TagRequestDto.builder()
                .tag_id(tag.getTag_id())
                .tag_name(tag.getTag_name())
                .build();
    }

    @Transactional
    @Override
    public void deleteTag(Integer id) {
        tagRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateTag(Integer id, TagRequestDto tagRequestDto) {
        Optional<Tag> optionalTag = tagRepository.findById(id);

        if (optionalTag.isPresent()){
            Tag existingTag = optionalTag.get();

            existingTag.setTag_name(tagRequestDto.getTag_name());

            tagRepository.save(existingTag);
        }
        else{
            System.out.println("no instance with "+id);
        }

    }
}
