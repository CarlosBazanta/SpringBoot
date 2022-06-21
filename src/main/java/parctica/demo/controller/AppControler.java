package parctica.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import parctica.demo.entity.UserEntity;
import parctica.demo.repository.UserRepository;

@Controller
public class AppControler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String loginView(){

        return "living";

    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity() {
        });

        return"signup_form";
    }

    @PostMapping("/process_register")

    public String processRegister(UserEntity userEntity){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode((userEntity.getPassword()));
        userEntity.setPassword(encodedPassword);

        userRepository.save(userEntity);

        return"register-succes";
    }

}
