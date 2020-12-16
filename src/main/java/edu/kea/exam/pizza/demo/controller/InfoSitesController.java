package edu.kea.exam.pizza.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoSitesController {

    @GetMapping("InfoSites/Contact")
    public String Contact(){

        return "InfoSites/Contact";
    }

    @GetMapping("InfoSites/Welcome")
    public String Welcome(){

        return "InfoSites/Welcome";
    }

    @GetMapping("InfoSites/WhoAreWe")
    public String WhoAreWe(){

        return "InfoSites/WhoAreWe";
    }
}
