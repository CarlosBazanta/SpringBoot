package parctica.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AppController {

    @GetMapping({"/","/login"})
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/user")
    public String user(){
        return "user";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }


}
