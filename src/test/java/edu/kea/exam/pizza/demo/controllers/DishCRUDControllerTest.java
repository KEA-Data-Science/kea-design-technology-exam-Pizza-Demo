package edu.kea.exam.pizza.demo.controllers;
import edu.kea.exam.pizza.demo.controller.DishCRUDController;
import edu.kea.exam.pizza.demo.model.Dish;
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
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class DishCRUDControllerTest {



    //test subjects
    @Mock
    SideCrudRepository sideRepo;

    @Mock
    DishCrudRepository dishRepo;

    @Mock
    DrinkCrudRepository drinkRepo;

    @Mock
    Model mockModel;

    DishCRUDController dishCRUDController;


    @BeforeEach
    void setUp() throws Exception{
        sideRepo = mock(SideCrudRepository.class);
        when(sideRepo.findAll()).thenReturn(new ArrayList<>());

        dishRepo = mock(DishCrudRepository.class);
        when(dishRepo.findAll()).thenReturn(new ArrayList<>());

        drinkRepo = mock(DrinkCrudRepository.class);
        when(drinkRepo.findAll()).thenReturn(new ArrayList<>());

        dishCRUDController = new DishCRUDController(dishRepo,sideRepo,drinkRepo);
        /* Kian: linien over erstatter de fire nedenstående - for at undgå brugen af en ikke-eksisterende paramterløs constructor. */
//        dishCRUDController = new DishCRUDController();
//        dishCRUDController.setSideRepository(sideRepo);
//        dishCRUDController.setDishRepository(dishRepo);
//        dishCRUDController.setDrinkRepository(drinkRepo);

        mockModel = mock(Model.class);

    }

    // testcase 1
    @Test
    void testCreateDish() throws Exception{


    }
    @Test
    void testSaveDish() throws Exception {
    }

    @Test
    void testEditDish() throws Exception {
    }

    @Test
    void testEditDishproccess() throws Exception {
    }

    @Test
    void testEditDishdone() throws Exception {
    }
}



