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
    public void updateComment(Integer id, CommentRequestDto commentRequestDto){
        // 주어진 ID에 해당하는 댓글을 찾습니다.
        Optional<Comment> optionalComment = commentRepository.findById(id);

        // ID에 해당하는 댓글이 존재하는지 확인합니다.
        if (optionalComment.isPresent()) {
            Comment existingComment = optionalComment.get();

            // 새로운 데이터로 댓글을 업데이트합니다.
            existingComment.setComment_writer(commentRequestDto.getComment_writer());
            existingComment.setComment_content(commentRequestDto.getComment_content());

            // 업데이트된 댓글을 저장합니다.
            commentRepository.save(existingComment);
        } else {
            // ID에 해당하는 댓글이 없는 경우에 대한 처리를 여기에 추가할 수 있습니다.
            // 예를 들어, 예외를 던지거나 로그를 남기는 등의 처리가 가능합니다.
            // 여기에서는 간단히 로그를 출력하도록 합니다.
            System.out.println("댓글을 찾을 수 없습니다. ID: " + id);
        }
    }
}
