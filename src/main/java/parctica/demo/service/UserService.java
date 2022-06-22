package parctica.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import parctica.demo.entity.UserEntity;
import parctica.demo.repository.UserRepository;
import parctica.demo.repository.UserServiceRepository;

@Service
public class UserService implements UserServiceRepository{

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository){

        this.userRepository=userRepository;

    }

    @Override
    public UserEntity saveEntity(UserEntity userEntity){
        UserEntity user = new UserEntity(
            userEntity.getEmail(),
            userEntity.getUsername(),
            userEntity.getName(),
            passwordEncoder.encode(userEntity.getPassword())

        );

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserEntity userEntity = userRepository.findByEmail(username);

        if(userEntity == null){
            throw new UsernameNotFoundException("Usuario o password inválidos");
            
        }
        return new User(userEntity.getEmail(),userEntity.getPassword(), null);
    }

    @Override
    public List<UserEntity> userList() {
        return userRepository.findAll();
    }

}



