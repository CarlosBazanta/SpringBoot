package parctica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parctica.demo.models.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);

}
