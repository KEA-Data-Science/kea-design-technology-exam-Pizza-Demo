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


    /*Kommentar fra Kian: Emil, du har vist ændret constructoren for at få testen til at virke;
    * det har desværre gjort controlleren ukampdygtig: Grunden til jeg ikke har brugt
    * autowired her, er netop for at gøre det muligt, i testene, at lave mocked-dependency injection.
    * For at få skidtet til at kompilere og virke, så ændrer jeg lige detaljen i dine associerede tests.*/

    DishCrudRepository dishRepository;
    SideCrudRepository sideRepository;
    DrinkCrudRepository drinkRepository;

    /* Constructoren uden parametre forhindrer Spring Frameworket i ordenligt at initializere data, så den er slettet */

    public CardController(DishCrudRepository dishRepository, SideCrudRepository sideRepository, DrinkCrudRepository drinkRepository) {
        this.dishRepository = dishRepository;
        this.sideRepository = sideRepository;
        this.drinkRepository = drinkRepository;
    }

    public DishCrudRepository getDishRepository() {
        return dishRepository;
    }

    public void setDishRepository(DishCrudRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public SideCrudRepository getSideRepository() {
        return sideRepository;
    }

    public void setSideRepository(SideCrudRepository sideRepository) {
        this.sideRepository = sideRepository;
    }

    public DrinkCrudRepository getDrinkRepository() {
        return drinkRepository;
    }

    public void setDrinkRepository(DrinkCrudRepository drinkRepository) {
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
