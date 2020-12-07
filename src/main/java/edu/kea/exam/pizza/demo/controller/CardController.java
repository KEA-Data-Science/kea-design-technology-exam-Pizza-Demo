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
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"dishes","sides","drinks"})
public class CardController {

    DishCrudRepository dishRepository;
    SideCrudRepository sideRepository;
    DrinkCrudRepository drinkRepository;

    public CardController(DishCrudRepository dishRepository, SideCrudRepository sideRepository, DrinkCrudRepository drinkRepository) {
        this.dishRepository = dishRepository;
        this.sideRepository = sideRepository;
        this.drinkRepository = drinkRepository;
    }

    /* these three assessor-methods exist for the @SessionAttributes annotation to work */
    @ModelAttribute("dishes")
    public Iterable<Dish> getDishes(){
        return dishRepository.findAll();
    }

    @ModelAttribute("sides")
    public Iterable<Side> getSides(){
        return sideRepository.findAll();
    }

    @ModelAttribute("drinks")
    public Iterable<Drink> getDrinks(){
        return drinkRepository.findAll();
    }

    @GetMapping("/card")
    public String showCard(
            @ModelAttribute("dishes") Iterable<Dish> dishes,
            @ModelAttribute("sides") Iterable<Side> sides,
            @ModelAttribute("drinks") Iterable<Drink> drinks,
            Model model){

        model.addAttribute("dishes",getDishes());
        model.addAttribute("sides",getSides());
        model.addAttribute("drinks",getDrinks());

        return "card/card-base";
    }
}
