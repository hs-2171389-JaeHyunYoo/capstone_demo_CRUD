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
    public PostResponseDto updatePost(@PathVariable("id") Integer id,
                                      @RequestBody @Validated PostRequestDto request){
        postService.updatePost(id, request);

        Optional<Post> findPost = postRepository.findById(id);
        Post post = findPost.get();

        return new PostResponseDto(
                post.getPost_id(),
                post.getPost_writer(),
                post.getPost_title(),
                post.getPost_content()
        );
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
