package demoForCapstone.mySelf.controller;

import demoForCapstone.mySelf.domain.Board;
import demoForCapstone.mySelf.dto.BoardRequestDto;
import demoForCapstone.mySelf.dto.BoardResponseDto;
import demoForCapstone.mySelf.repository.BoardRepository;
import demoForCapstone.mySelf.service.BoardService;
import demoForCapstone.mySelf.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardServiceImpl boardService;
    private final BoardRepository boardRepository;

    @PostMapping("/api/post")
    public BoardResponseDto savePost(@RequestBody @Validated BoardRequestDto request) {
        boardService.savePost(request);

        return new BoardResponseDto(
                request.ToEntity().getTitle(),
                request.ToEntity().getWriter(),
                request.ToEntity().getContent());
    }

    @PutMapping("/api/post/{id}")
    public BoardResponseDto updatePost(@PathVariable("id") Long id,
                                       @RequestBody @Validated BoardRequestDto request) {

        boardService.update(id, request);
        Optional<Board> findPost = boardRepository.findById(id);
        Board board = findPost.get();

        return new BoardResponseDto(
                board.getTitle(),
                board.getWriter(),
                board.getContent());
    }

    @GetMapping("/api/board/posts")
    public List<BoardRequestDto> findPosts(){
        List<Board> findAll = boardRepository.findAll();
        List<BoardRequestDto> allPost = new ArrayList<>();

        for(Board board : findAll){
            BoardRequestDto build = BoardRequestDto.builder()
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .title(board.getTitle())
                    .build();

            allPost.add(build);
        }

        return allPost;
    }


    @GetMapping("/api/board/post/{id}")
    public BoardResponseDto findPost(@PathVariable("id") Long id){
        BoardRequestDto post = boardService.getPost(id);

        return new BoardResponseDto(
                post.getWriter(),
                post.getTitle(),
                post.getContent()
        );
    }

    @DeleteMapping("/api/post/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        boardService.deletePost(id);
    }
}
