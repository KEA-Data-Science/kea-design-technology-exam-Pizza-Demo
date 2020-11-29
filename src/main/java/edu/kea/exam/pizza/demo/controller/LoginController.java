package edu.kea.exam.pizza.demo.controller;

import edu.kea.exam.pizza.demo.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView getLoginPage() { //Standard login controller
        return new ModelAndView("/login/Login", "command", new Login());
    }

    @RequestMapping(value = "/processLogin", method = RequestMethod.POST)
    public ModelAndView processLogin(@ModelAttribute("login") Login login) {  //Her bliver det proccesset

        String userName = login.getUserName();
        String password = login.getPassword();

        if ("admin".equalsIgnoreCase(userName) //Self explained
                && "pizza".equalsIgnoreCase(password)) {
            ModelAndView mv = new ModelAndView("success"); //Her skal der ændres til den edit siden
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("/login/Login");
            return mv;
        }

    }
}
