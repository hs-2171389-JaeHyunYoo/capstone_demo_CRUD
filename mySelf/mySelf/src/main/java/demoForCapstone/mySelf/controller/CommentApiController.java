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
    public CommentResponseDto updateComment(@PathVariable("id") Integer id,
                                            @RequestBody @Validated CommentRequestDto request) {
        commentService.updateComment(id, request);
        Optional<Comment> findComment = commentRepository.findById(id);
        Comment comment = findComment.get();

        return new CommentResponseDto(
                comment.getComment_id(),
                comment.getComment_writer(),
                comment.getComment_content()
        );
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
