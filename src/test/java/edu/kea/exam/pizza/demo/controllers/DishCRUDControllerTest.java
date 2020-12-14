package edu.kea.exam.pizza.demo.controllers;
import edu.kea.exam.pizza.demo.controller.DishCRUDController;
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

        dishRepo = mock(DishCrudRepository.class);

        drinkRepo = mock(DrinkCrudRepository.class);

        dishCRUDController = new DishCRUDController(dishRepo,sideRepo,drinkRepo);

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



