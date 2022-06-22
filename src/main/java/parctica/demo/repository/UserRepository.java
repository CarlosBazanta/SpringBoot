package parctica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import parctica.demo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {

    UserEntity findByEmail(String email);

}
