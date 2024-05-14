package demoForCapstone.mySelf.repository;

import demoForCapstone.mySelf.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
