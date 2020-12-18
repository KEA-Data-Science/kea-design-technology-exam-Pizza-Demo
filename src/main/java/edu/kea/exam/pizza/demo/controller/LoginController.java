package edu.kea.exam.pizza.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/* The login controller provides access points to the login-template, and Admin page */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage() { //Standard login controller
        return "login/login";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin/admin";
    }

}
