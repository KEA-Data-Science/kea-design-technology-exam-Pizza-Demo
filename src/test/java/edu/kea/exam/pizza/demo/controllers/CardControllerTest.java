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
import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CardControllerTest {

    //test subjects
    @Mock
    SideCrudRepository sideRepo;

    @Mock
    DishCrudRepository dishRepo;

    @Mock
    DrinkCrudRepository drinkRepo;

    @Mock
    Model mockModel;

    CardController cardController;

    @BeforeEach
    void Setup() throws Exception{
        sideRepo = mock(SideCrudRepository.class);
        when(sideRepo.findAll()).thenReturn(new ArrayList<>());

        dishRepo = mock(DishCrudRepository.class);
        when(dishRepo.findAll()).thenReturn(new ArrayList<>());

        drinkRepo = mock(DrinkCrudRepository.class);
        when(drinkRepo.findAll()).thenReturn(new ArrayList<>());


        cardController = new CardController();
        cardController.setSideRepository(sideRepo);
        cardController.setDishRepository(dishRepo);
        cardController.setDrinkRepository(drinkRepo);

        mockModel = mock(Model.class);

    }

    // testcase 1
    @Test
        void testShowCard() throws Exception{
        assertEquals("card/card-base", cardController.showCard(mockModel));

        verify(sideRepo, times(1)).findAll();
        verify(mockModel, times(1)).addAttribute("side", new ArrayList<>());

        verify(dishRepo, times(1)).findAll();
        verify(mockModel, times(1)).addAttribute("dish", new ArrayList<>());

        verify(drinkRepo, times(1)).findAll();
        verify(mockModel, times(1)).addAttribute("drink", new ArrayList<>());


    }

}
