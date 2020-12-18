package edu.kea.exam.pizza.demo.controller;

import edu.kea.exam.pizza.demo.model.Dish;
import edu.kea.exam.pizza.demo.model.Drink;
import edu.kea.exam.pizza.demo.model.Side;
import edu.kea.exam.pizza.demo.persistence.DishCrudRepository;
import edu.kea.exam.pizza.demo.persistence.DrinkCrudRepository;
import edu.kea.exam.pizza.demo.persistence.SideCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

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


    /* Editing overview page */
    @GetMapping("internal/edit-products")
    public String editDish(Model model) {
        Iterable<Dish> dishList = dishRepository.findAll();
        Iterable<Drink> drinkList = drinkRepository.findAll();
        Iterable<Side> sideList = sideRepository.findAll();
        model.addAttribute("dishList", dishList);
        model.addAttribute("drinkList", drinkList);
        model.addAttribute("sideList", sideList);
        return "crud/edit-products";
    }

    /* Dishes */

    @GetMapping("internal/new-dish")
    public String createDish(Model model, @ModelAttribute("dish") Dish dish) {
        model.addAttribute("dish", dish);
        return "crud/dish/new-dish";
    }

    @PostMapping("internal/save-dish")
    public String saveDish(@ModelAttribute("dish") @Valid Dish dish, Errors errors) {
        if (errors.hasErrors()) {
            return "crud/dish/new-dish";
        } else {

            dishRepository.save(dish);
            System.out.println(dish);
            return "admin/admin";
        }
    }

    @GetMapping("internal/edit-dish/{id}")
    public String editDishProcess(Model model, @PathVariable("id") int id) {
        Optional<Dish> dish = dishRepository.findById(id);
        model.addAttribute("dish", dish.get());
        return "crud/dish/edit-dish-process";
    }

    @PostMapping("/edit-dish-done")
    public String editDishDone(@ModelAttribute Dish dish) {
        dishRepository.save(dish);
        return "redirect:/admin";
    }

    @GetMapping("internal/delete-dish/{id}")
    public String deleteDish(Model model, @PathVariable("id") int id) {
        dishRepository.deleteById(id);
        return "redirect:/admin";
    }

    /* Sides */

    @GetMapping("internal/new-side")
    public String createSide(Model model, @ModelAttribute("side") Side side) {
        model.addAttribute("side", side);
        return "crud/side/new-side";
    }

    @PostMapping("internal/save-side")
    public String saveSide(@ModelAttribute("side") @Valid Side side, Errors errors) {
        if (errors.hasErrors()) {
            return "crud/side/new-side";
        } else {
            /* this is silly, but a bug was weird and this was quick */
            Iterable<Side> all = sideRepository.findAll();
            ArrayList<Side> sides = new ArrayList<>();
            all.forEach(sides::add);
            side.setId(sides.size()+1);

            sideRepository.save(side);
            System.out.println(side);
            return "admin/admin";
        }
    }

    @GetMapping("internal/edit-side/{id}")
    public String editSideProcess(Model model, @PathVariable("id") int id) {
        Optional<Side> side = sideRepository.findById(id);
        model.addAttribute("side", side.get());
        return "crud/side/edit-side-process";
    }

    @PostMapping("/edit-side-done")
    public String editSideDone(@ModelAttribute Side dish) {
        sideRepository.save(dish);
        return "redirect:/admin";
    }

    @GetMapping("internal/delete-side/{id}")
    public String deleteSide(Model model, @PathVariable("id") int id) {
        sideRepository.deleteById(id);
        return "redirect:/admin";
    }

    /* Drinks */

    @GetMapping("internal/new-drink")
    public String createDrink(Model model, @ModelAttribute("drink") Drink drink) {
        model.addAttribute("drink", drink);
        return "crud/drink/new-drink";
    }

    @PostMapping("internal/save-drink")
    public String saveDrink(@ModelAttribute("drink") @Valid Drink drink, Errors errors) {
        if (errors.hasErrors()) {
            return "crud/drink/new-drink";
        } else {

            drinkRepository.save(drink);
            System.out.println(drink);
            return "admin/admin";
        }
    }

    @GetMapping("internal/edit-drink/{id}")
    public String editDrinkProcess(Model model, @PathVariable("id") int id) {
        Optional<Drink> dish = drinkRepository.findById(id);
        model.addAttribute("drink", dish.get());
        return "crud/drink/edit-drink-process";
    }

    @PostMapping("/edit-drink-done")
    public String editDrinkDone(@ModelAttribute Drink dish) {
        drinkRepository.save(dish);
        return "redirect:/admin";
    }

    @GetMapping("internal/delete-drink/{id}")
    public String deleteDrink(Model model, @PathVariable("id") int id) {
        drinkRepository.deleteById(id);
        return "redirect:/admin";
    }
}
