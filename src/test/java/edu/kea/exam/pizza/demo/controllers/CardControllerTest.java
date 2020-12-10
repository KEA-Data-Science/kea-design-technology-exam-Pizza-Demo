package edu.kea.exam.pizza.demo.controllers;
import edu.kea.exam.pizza.demo.controller.CardController;
import static org.assertj.core.api.Assertions.assertThat;
import edu.kea.exam.pizza.demo.persistence.DishCrudRepository;
import edu.kea.exam.pizza.demo.persistence.DrinkCrudRepository;
import edu.kea.exam.pizza.demo.persistence.SideCrudRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
// import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class CardControllerTest {

    //test subject
    @Autowired
    CardController cardController;
    SideCrudRepository sideRepo;
    DishCrudRepository dishRepo;
    DrinkCrudRepository drinkRepo;

    // testcase 1
    @Test
    void showCard() throws Exception{
        assertThat(cardController).isNotNull();
        assertThat(dishRepo).isEqualTo(dishRepo);
        assertThat(sideRepo).isEqualTo(sideRepo);
        assertThat(drinkRepo).isEqualTo(drinkRepo);

    }

}
