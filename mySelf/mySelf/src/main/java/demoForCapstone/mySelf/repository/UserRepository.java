package demoForCapstone.mySelf.repository;

import demoForCapstone.mySelf.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
