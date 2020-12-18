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
import org.springframework.validation.Errors;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

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

    @Mock
    Dish testDish;

    @Mock
    Errors testError;

    DishCRUDController dishCRUDController;


    @BeforeEach
    void setUp() throws Exception{
        sideRepo = mock(SideCrudRepository.class);

        dishRepo = mock(DishCrudRepository.class);
        when(dishRepo.findAll()).thenReturn(new ArrayList<>());

        when(dishRepo.findById(1)).thenReturn(java.util.Optional.of(testDish));

        drinkRepo = mock(DrinkCrudRepository.class);

        dishCRUDController = new DishCRUDController(dishRepo,sideRepo,drinkRepo);

        mockModel = mock(Model.class);

    }

    // testcase 1
    @Test
    void testCreateDish() throws Exception{
        assertEquals("crud/new-dish",dishCRUDController.createDish(mockModel, testDish));

        //verify(dishRepo,times(1)).save(testDish);
    }

    @Test
    void testSaveDish() throws Exception {
        assertEquals("index",dishCRUDController.saveDish(testDish, testError));
    }

    @Test
    void testEditDish() throws Exception {
        assertEquals("crud/edit-dish",dishCRUDController.editDish(mockModel));
    }

    @Test
    void testEditDishproccess() throws Exception {
        assertEquals("crud/edit-dish-process",dishCRUDController.editDishproccess(mockModel, 1));
    }

    @Test
    void testEditDishdone() throws Exception {
        assertEquals("redirect:/admin",dishCRUDController.editDishdone(testDish));

    }
}
