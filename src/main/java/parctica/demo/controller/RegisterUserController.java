package parctica.demo.controller;

import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import parctica.demo.controller.DTO.UserRegisterDTO;
import parctica.demo.service.UserService;

@Controller
//mapeo de la ruta a utilizar
@RequestMapping("/register")

public class RegisterUserController {

    private UserService userService;

    public  RegisterUserController (UserService userService){
        this.userService=userService;
    }

    @ModelAttribute("user")
    public UserRegisterDTO returnNewUserRegisterDTO(){
        return new UserRegisterDTO();
    }

    //controla la direccion Url
    @GetMapping
    public String showRegistrationForm(){
        return "register";
    }

    //en caso de ser exitosa indica en el caso url
    @PostMapping
    public String RegisterUserForm(@ModelAttribute("user") UserRegisterDTO registerDTO){
        userService.save(registerDTO);
        return "redirect:/registro?exito";
    }

}
