package demoForCapstone.mySelf.repository;

import demoForCapstone.mySelf.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
