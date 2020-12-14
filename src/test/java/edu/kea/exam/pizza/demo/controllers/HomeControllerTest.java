package edu.kea.exam.pizza.demo.controllers;
import edu.kea.exam.pizza.demo.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class HomeControllerTest {

    HomeController homeController;

    @BeforeEach
    void setUp(){

    homeController = new HomeController();
}
    @Test
    void testIndex(){
        assertEquals("index", homeController.index());
    }
}
