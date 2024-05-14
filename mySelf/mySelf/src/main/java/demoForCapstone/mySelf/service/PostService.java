package demoForCapstone.mySelf.service;

import demoForCapstone.mySelf.dto.PostRequestDto;

import java.util.List;

public interface PostService {
    public void savePost(PostRequestDto postRequestDto);
    public List<PostRequestDto> getAllPost() ;
    public PostRequestDto getPost(Integer id);
    public void deletePost(Integer id);
    public void updatePost(Integer id, PostRequestDto postRequestDto);
}
