package parctica.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import parctica.demo.controller.DTO.UserRegisterDTO;
import parctica.demo.models.User;


public interface UserService extends UserDetailsService {

     User save(UserRegisterDTO registroDTO); //Es el metodo que se encarga de guardar

}
