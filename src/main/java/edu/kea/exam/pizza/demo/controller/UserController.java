package edu.kea.exam.pizza.demo.controller;

import edu.kea.exam.pizza.demo.security.User;
import edu.kea.exam.pizza.demo.security.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/sign-up")
    public String newSignUp(){
        return "user/sign-up";
    }

    @GetMapping("/sign-up-now")
    public String newSignUpSave(@RequestParam("username") String username,
                                @RequestParam("password") String password){

        /* introduce tests:
        * 1. is username unique TODO: not implemented yet*/

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        System.out.println(user);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encodedPassword = encoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        User save = userRepository.save(user);
        System.out.println("BUPA BUP DI DA DUP");
        System.out.println(save.toString());

        return "redirect:/login";
    }

}
