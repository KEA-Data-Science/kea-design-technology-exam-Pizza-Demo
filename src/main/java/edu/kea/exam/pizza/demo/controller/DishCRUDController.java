package edu.kea.exam.pizza.demo.controller;

import edu.kea.exam.pizza.demo.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"dish"})
public class DishCRUDController
{

    @GetMapping("/new-dish")
    public String createDish(@ModelAttribute("dish") Dish dish,
                             Model model)
    {
        model.addAttribute("dish",dish);
        return "/new-dish/initial-view";
    }


    @ModelAttribute("dish")
    public Dish getDish(){ return new Dish(); }
}
