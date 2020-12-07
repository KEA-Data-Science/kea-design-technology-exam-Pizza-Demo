package edu.kea.exam.pizza.demo.controller;

import edu.kea.exam.pizza.demo.model.Dish;
import edu.kea.exam.pizza.demo.model.Drink;
import edu.kea.exam.pizza.demo.model.Side;
import edu.kea.exam.pizza.demo.persistence.DishCrudRepository;
import edu.kea.exam.pizza.demo.persistence.DrinkCrudRepository;
import edu.kea.exam.pizza.demo.persistence.SideCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.Errors;


import javax.validation.Valid;
import java.util.List;

@Controller
public class DishCRUDController {

    DishCrudRepository dishRepository;
    SideCrudRepository sideRepository;
    DrinkCrudRepository drinkRepository;


    public DishCRUDController(DishCrudRepository dishRepository, SideCrudRepository sideRepository, DrinkCrudRepository drinkRepository) {
        this.dishRepository = dishRepository;
        this.sideRepository = sideRepository;
        this.drinkRepository = drinkRepository;
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

            dishRepository.save(dish);
            System.out.println(dish);
            return "Index";
        }
    }
    @GetMapping("internal/edit-dish")
    public String editDish(Model model) {
        Iterable<Dish> dishList = dishRepository.findAll();
        Iterable<Drink> drinkList = drinkRepository.findAll();
        Iterable<Side> sideList = sideRepository.findAll();
        model.addAttribute("dishList", dishList);
        model.addAttribute("drinkList", drinkList);
        model.addAttribute("sideList", sideList);
        return "crud/edit-dish";
    }


}
