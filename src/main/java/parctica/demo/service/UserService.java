package parctica.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import parctica.demo.entity.RoleEntity;
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
                userEntity.getName(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                passwordEncoder.encode(userEntity.getPassword()),
                userEntity.getLicense(),
                Arrays.asList(new RoleEntity(userEntity.getLicense()))
        );

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserEntity userEntity = userRepository.findByEmail(username);

        if(userEntity == null){
            throw new UsernameNotFoundException("Usuario o password inválidos");
            
        }
        return new User(userEntity.getEmail(),userEntity.getPassword(), mapAutority(userEntity.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapAutority(Collection<RoleEntity> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
    }

    @Override
    public List<UserEntity> userList() {
        return userRepository.findAll();
    }

}



