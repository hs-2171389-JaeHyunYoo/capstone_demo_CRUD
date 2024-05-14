package demoForCapstone.mySelf.service;

import demoForCapstone.mySelf.domain.Post;
import demoForCapstone.mySelf.dto.PostRequestDto;
import demoForCapstone.mySelf.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    @Transactional
    @Override
    public void savePost(PostRequestDto postRequestDto) {
        postRepository.save(postRequestDto.toEntity());
    }

    @Transactional
    @Override
    public List<PostRequestDto> getAllPost() {
        List<Post> all = postRepository.findAll();
        List<PostRequestDto> postRequestDtoList = new ArrayList<>();

        for (Post post : all) {
            PostRequestDto postDto = PostRequestDto.builder()
                    .post_id(post.getPost_id())
                    .post_writer(post.getPost_writer())
                    .post_title(post.getPost_title())
                    .post_content(post.getPost_content())
                    .build();

            postRequestDtoList.add(postDto);
        }
        return postRequestDtoList;
    }

    @Transactional
    @Override
    public PostRequestDto getPost(Integer id) {
        Optional<Post> postWrapper = postRepository.findById(id);
        Post post = postWrapper.get();

        return PostRequestDto.builder()
                .post_id(post.getPost_id())
                .post_writer(post.getPost_writer())
                .post_title(post.getPost_title())
                .post_content(post.getPost_content())
                .build();
    }

    @Transactional
    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updatePost(Integer id, PostRequestDto postRequestDto) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if(optionalPost.isPresent()){
            Post existingPost = optionalPost.get();

            existingPost.setPost_writer(postRequestDto.getPost_writer());
            existingPost.setPost_title(postRequestDto.getPost_title());
            existingPost.setPost_content(postRequestDto.getPost_content());

            postRepository.save(existingPost);
        }

        else{
            System.out.println("no instance with " + id);
        }
    }
}
