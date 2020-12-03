package edu.kea.exam.pizza.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage() { //Standard login controller
        return "login/login";
    }

//    @RequestMapping(value = "/processLogin", method = RequestMethod.POST)
//    public ModelAndView processLogin(@ModelAttribute("login") Login login) {  //Her bliver det proccesset
//
//        String userName = login.getUserName();
//        String password = login.getPassword();
//
//        if ("admin".equalsIgnoreCase(userName) //Self explained
//                && "pizza".equalsIgnoreCase(password)) {
//            ModelAndView mv = new ModelAndView("admin/Admin"); //Her skal der ændres til den edit siden
//            return mv;
//        } else {
//            ModelAndView mv = new ModelAndView("/login/Login");
//            return mv;
//        }
//    }

}
