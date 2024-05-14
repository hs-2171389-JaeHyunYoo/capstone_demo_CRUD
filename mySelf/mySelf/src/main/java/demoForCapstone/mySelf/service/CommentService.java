package demoForCapstone.mySelf.service;

import demoForCapstone.mySelf.dto.CommentRequestDto;

import java.util.List;

public interface CommentService {
    public void saveComment(CommentRequestDto commentRequestDto);

    public List<CommentRequestDto> getAllComment();

    public CommentRequestDto getComment(Integer id);

    public void deleteComment(Integer id);

    public void updateComment(Integer id, CommentRequestDto commentRequestDto);
}
