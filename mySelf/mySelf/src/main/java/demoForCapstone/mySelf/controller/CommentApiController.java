package demoForCapstone.mySelf.controller;

import demoForCapstone.mySelf.domain.Comment;
import demoForCapstone.mySelf.dto.CommentRequestDto;
import demoForCapstone.mySelf.dto.CommentResponseDto;
import demoForCapstone.mySelf.repository.CommentRepository;
import demoForCapstone.mySelf.service.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentServiceImpl commentService;
    private final CommentRepository commentRepository;

    @PostMapping("/comment/insert")
    public CommentResponseDto saveComment(@RequestBody @Validated CommentRequestDto request){
        commentService.saveComment(request);

        return new CommentResponseDto(
                request.toEntity().getComment_id(),
                request.toEntity().getComment_writer(),
                request.toEntity().getComment_content()
        );
    }

    @PutMapping("/comment/update/{id}")
    public void updateComment(@PathVariable("id") Integer id,
                                            @RequestBody @Validated CommentRequestDto request) {
        // 주어진 ID에 해당하는 댓글을 찾습니다.
        Optional<Comment> optionalComment = commentRepository.findById(id);

        // ID에 해당하는 댓글이 존재하는지 확인합니다.
        if (optionalComment.isPresent()) {
            Comment existingComment = optionalComment.get();

            // 새로운 데이터로 댓글을 업데이트합니다.
            existingComment.setComment_writer(request.getComment_writer());
            existingComment.setComment_content(request.getComment_content());

            // 업데이트된 댓글을 저장합니다.
            commentRepository.save(existingComment);
        }
        else {
            // ID에 해당하는 댓글이 없는 경우에 대한 처리를 여기에 추가할 수 있습니다.
            // 예를 들어, 예외를 던지거나 로그를 남기는 등의 처리가 가능합니다.
            // 여기에서는 간단히 로그를 출력하도록 합니다.
            System.out.println("댓글을 찾을 수 없습니다. ID: " + id);
        }
    }

    @GetMapping("/comment/readAll")
    public List<CommentRequestDto> findAllComments(){
        List<Comment> findAll = commentRepository.findAll();
        List<CommentRequestDto> allComment = new ArrayList<>();

        for (Comment comment : findAll) {
            CommentRequestDto build = CommentRequestDto.builder()
                    .comment_id(comment.getComment_id())
                    .comment_writer(comment.getComment_writer())
                    .comment_content(comment.getComment_content())
                    .build();

            allComment.add(build);
        }

        return allComment;
    }

    @GetMapping("/comment/read/{id}")
    public CommentResponseDto findComment(@PathVariable("id") Integer id) {
        CommentRequestDto comment = commentService.getComment(id);

        return new CommentResponseDto(
                comment.getComment_id(),
                comment.getComment_writer(),
                comment.getComment_content()
        );
    }

    @DeleteMapping("/comment/delete/{id}")
    public void deleteComment(@PathVariable("id") Integer id){
        commentService.deleteComment(id);
    }

}
