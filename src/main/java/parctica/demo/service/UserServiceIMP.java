package parctica.demo.service;

import org.springframework.stereotype.Service;
import parctica.demo.controller.DTO.UserRegisterDTO;
import parctica.demo.models.Role;
import parctica.demo.models.User;
import parctica.demo.repository.UserRepository;

import java.util.Arrays;

@Service

public abstract class UserServiceIMP implements UserService {

    private UserRepository userRepository;

    public  UserServiceIMP(UserRepository userRepository){

        this.userRepository = userRepository;

    }

    @Override
    //Guarda los datos en la BD
    public User save(UserRegisterDTO registerDTO){
        User user = new User(
                registerDTO.getName(),
                registerDTO.getUserName(),
                registerDTO.getEmail(),
                registerDTO.getPassword(),
                Arrays.asList(new Role("ROLE_USER"))
        );
        return userRepository.save(user);
    }

}
