package demoForCapstone.mySelf.service;

import demoForCapstone.mySelf.dto.TagRequestDto;

import java.util.List;

public interface TagService {
    public void saveTag(TagRequestDto tagRequestDto);
    public List<TagRequestDto> getAllTags();
    public TagRequestDto getTag(Integer id);
    public void deleteTag(Integer id);
    public void updateTag(Integer id, TagRequestDto tagRequestDto);
}
