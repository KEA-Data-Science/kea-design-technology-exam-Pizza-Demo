package edu.kea.exam.pizza.demo.controllers;
import edu.kea.exam.pizza.demo.controller.DishCRUDController;
import edu.kea.exam.pizza.demo.persistence.DishCrudRepository;
import edu.kea.exam.pizza.demo.persistence.DrinkCrudRepository;
import edu.kea.exam.pizza.demo.persistence.SideCrudRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class DishCRUDControllerTest {


    //test subject
    @Autowired
    DishCRUDController dishCRUDController;
    SideCrudRepository sideRepo;
    DishCrudRepository dishRepo;
    DrinkCrudRepository drinkRepo;

    // testcase 1
    @Test
    void createDish() throws Exception{
        assertThat(dishCRUDController).isNotNull();
        assertThat(dishRepo).isEqualTo(dishRepo);

    }

            //saveDish


   //editDish

           // editDishproccess

  //  editDishdone


}
    //@Test
