package parctica.demo.repository;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import java.util.List;
import parctica.demo.entity.UserEntity;



public interface UserServiceRepository extends UserDetailsService {

    UserEntity saveEntity(UserEntity userEntity);
    
    List<UserEntity> userList();



}
