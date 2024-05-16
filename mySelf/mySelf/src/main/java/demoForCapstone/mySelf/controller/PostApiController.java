package demoForCapstone.mySelf.controller;

import demoForCapstone.mySelf.domain.Post;
import demoForCapstone.mySelf.dto.PostRequestDto;
import demoForCapstone.mySelf.dto.PostResponseDto;
import demoForCapstone.mySelf.repository.PostRepository;
import demoForCapstone.mySelf.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostApiController {
    private final PostServiceImpl postService;
    private final PostRepository postRepository;

    @PostMapping("/post/insert")
    public PostResponseDto savePost(@RequestBody @Validated PostRequestDto request){
        postService.savePost(request);
        return new PostResponseDto(
                request.toEntity().getPost_id(),
                request.toEntity().getPost_writer(),
                request.toEntity().getPost_title(),
                request.toEntity().getPost_content()
        );
    }



    @PutMapping("/post/update/{id}")
    public void updatePost(@PathVariable("id") Integer id,
                                      @RequestBody @Validated PostRequestDto request){
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {
            Post existingComment = optionalPost.get();

            existingComment.setPost_id(request.getPost_id());
            existingComment.setPost_writer(request.getPost_writer());
            existingComment.setPost_title(request.getPost_title());
            existingComment.setPost_content(request.getPost_content());

            postRepository.save(existingComment);
        }
        else {
            // ID에 해당하는 댓글이 없는 경우에 대한 처리를 여기에 추가할 수 있습니다.
            // 예를 들어, 예외를 던지거나 로그를 남기는 등의 처리가 가능합니다.
            // 여기에서는 간단히 로그를 출력하도록 합니다.
            System.out.println("게시글을 찾을 수 없습니다. ID: " + id);
        }
    }

    @GetMapping("/post/readAll")
    public List<PostRequestDto> findAllPosts(){
        List<Post> findAll = postRepository.findAll();
        List<PostRequestDto> allPost = new ArrayList<>();

        for (Post post : findAll) {
            PostRequestDto build = PostRequestDto.builder()
                    .post_id(post.getPost_id())
                    .post_writer(post.getPost_writer())
                    .post_title(post.getPost_title())
                    .post_content(post.getPost_content())
                    .build();

            allPost.add(build);
        }

        return allPost;
    }


    @GetMapping("/post/read/{id}")
    public PostResponseDto findPost(@PathVariable("id") Integer id){
        PostRequestDto post = postService.getPost(id);

        return new PostResponseDto(
                post.getPost_id(),
                post.getPost_writer(),
                post.getPost_writer(),
                post.getPost_content()
        );
    }

    @DeleteMapping("/post/delete/{id}")
    public void deletePost(@PathVariable("id") Integer id) {
        postService.deletePost(id);
    }
}
