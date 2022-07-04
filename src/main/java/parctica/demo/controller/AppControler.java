package parctica.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import parctica.demo.entity.UserEntity;
import parctica.demo.repository.UserServiceRepository;

@Controller
public class AppControler {

    @Autowired
    private UserServiceRepository userServiceRepository;

    @ModelAttribute("user")
    public UserEntity returnNewUser(){
        return new UserEntity();
    }

    @ModelAttribute("homeUser")
    public UserEntity returnNewHomeUser(){
        return new UserEntity();
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return"register";
    }
        
    

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserEntity userEntity ){
        userServiceRepository.saveEntity(userEntity);

        return "redirect:/register?succes";
    }

    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("user",userServiceRepository.userList());
        return "index";
    }

    @PostMapping("/")
    public String homeRegister(@ModelAttribute("homeUser") UserEntity userEntity ){
        userServiceRepository.saveEntity(userEntity);

        return "redirect:/?succes";
    }


}
