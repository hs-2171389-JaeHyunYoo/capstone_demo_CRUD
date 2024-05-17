package demoForCapstone.mySelf.repository;

import demoForCapstone.mySelf.domain.Walking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalkingRepository extends JpaRepository<Walking, Integer> {
}
