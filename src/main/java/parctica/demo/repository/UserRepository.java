package parctica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parctica.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository <UserEntity, Long> {
}
