package demoForCapstone.mySelf.service;

import demoForCapstone.mySelf.dto.BoardRequestDto;

import java.util.List;

public interface BoardService {

    public void savePost(BoardRequestDto boardDto);

    public List<BoardRequestDto> getBoardList(Integer pageNum);

    public BoardRequestDto getPost(Long id);

    public void deletePost(Long id);

    public List<BoardRequestDto> searchPosts(String keyword);

    public void update(Long id, BoardRequestDto dto);
}