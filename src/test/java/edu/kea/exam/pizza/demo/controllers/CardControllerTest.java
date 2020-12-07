package edu.kea.exam.pizza.demo.controllers;
import edu.kea.exam.pizza.demo.controller.CardController;
import edu.kea.exam.pizza.demo.persistence.DishCrudRepository;
import edu.kea.exam.pizza.demo.persistence.DrinkCrudRepository;
import edu.kea.exam.pizza.demo.persistence.SideCrudRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import static org.mockito.Mockito.mock;

@SpringBootTest
@RunWith(SpringRunner.class)
class CardControllerTest {

    @Mock
    DishCrudRepository dishRepo;

    @Mock
    SideCrudRepository sideRepo;

    @Mock
    DrinkCrudRepository drinkRepo;

    @Mock
    Model mockModel;

    CardController cardController;  //test subject


    // arranges data between tests
    @BeforeEach
    void setUp(){
    mockModel = mock(Model.class);

    dishRepo = mock(DishCrudRepository.class);


    sideRepo = mock(SideCrudRepository.class);


    drinkRepo = mock(DrinkCrudRepository.class);

}
    // testcase
    @Test
    void showCard(){

    }
}
