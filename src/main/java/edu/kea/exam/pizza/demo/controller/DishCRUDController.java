package edu.kea.exam.pizza.demo.controller;

import edu.kea.exam.pizza.demo.model.Dish;
import edu.kea.exam.pizza.demo.persistence.DishCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.Errors;


import javax.validation.Valid;

@Controller

public class DishCRUDController {
    DishCrudRepository dishCrudRepository;

    public DishCRUDController(DishCrudRepository dishCrudRepository) {
        this.dishCrudRepository = dishCrudRepository;
    }

    @GetMapping("internal/new-dish")
    public String createDish(Model model, @ModelAttribute("dish") Dish dish) {
        model.addAttribute("dish",dish);
        return "crud/new-dish";
    }

    @PostMapping("/save-dish")
    public String saveDish( @ModelAttribute("dish") @Valid Dish dish, Errors errors) {
        if (errors.hasErrors()) {
            return "crud/new-dish";
        } else {

            dishCrudRepository.save(dish);
            System.out.println(dish);
            return "Index";
        }
    }


//    @ModelAttribute("dish")
//    public Dish getDish() {
//        return new Dish();
//    }
}
