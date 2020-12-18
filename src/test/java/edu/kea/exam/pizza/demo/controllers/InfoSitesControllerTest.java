package edu.kea.exam.pizza.demo.controllers;
import edu.kea.exam.pizza.demo.controller.InfoSitesController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class InfoSitesControllerTest {

   InfoSitesController infoSitesController;

    @BeforeEach
    void setUp(){

        infoSitesController = new InfoSitesController();
    }
    @Test
    void testContact(){
        assertEquals("InfoSites/Contact", infoSitesController.contact());
    }

    @Test
    void testWelcome(){
        assertEquals("InfoSites/Welcome", infoSitesController.welcome());
    }

    @Test
    void testWhoAreWe(){
        assertEquals("InfoSites/WhoAreWe", infoSitesController.whoAreWe());
    }

}
