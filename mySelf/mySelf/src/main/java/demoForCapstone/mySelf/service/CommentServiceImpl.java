package demoForCapstone.mySelf.service;

import demoForCapstone.mySelf.domain.Comment;
import demoForCapstone.mySelf.dto.CommentRequestDto;
import demoForCapstone.mySelf.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    @Override
    public void saveComment(CommentRequestDto commentRequestDto) {
        commentRepository.save(commentRequestDto.toEntity());
    }

    @Transactional
    @Override
    public List<CommentRequestDto> getAllComment() {
        List<Comment> all = commentRepository.findAll();
        List<CommentRequestDto> commentRequestDtoList = new ArrayList<>();

        for (Comment comment : all) {
            CommentRequestDto commentDto = CommentRequestDto.builder()
                    .comment_id(comment.getComment_id())
                    .comment_writer(comment.getComment_writer())
                    .comment_content(comment.getComment_content())
                    .build();

            commentRequestDtoList.add(commentDto);
        }

        return commentRequestDtoList;
    }

    @Transactional
    @Override
    public CommentRequestDto getComment(Integer id) {
        Optional<Comment> commentWrapper = commentRepository.findById(id);
        Comment comment = commentWrapper.get();

        return CommentRequestDto.builder()
                .comment_id(comment.getComment_id())
                .comment_writer(comment.getComment_writer())
                .comment_content(comment.getComment_content())
                .build();
    }

    @Transactional
    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateComment(Integer id, CommentRequestDto commentRequestDto) {
        Optional<Comment> byId = commentRepository.findById(id);
        Comment comment = byId.get();

        comment.updateComment(commentRequestDto.getComment_id(), commentRequestDto.getComment_writer(), commentRequestDto.getComment_content());

    }
}
