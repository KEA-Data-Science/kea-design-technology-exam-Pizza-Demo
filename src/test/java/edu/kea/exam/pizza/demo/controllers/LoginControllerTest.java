package edu.kea.exam.pizza.demo.controllers;
import edu.kea.exam.pizza.demo.controller.LoginController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class LoginControllerTest {

    LoginController loginController;

@BeforeEach
void setUp(){

    loginController = new LoginController();

}
    @Test
    void testGetLoginPage(){
        assertEquals("login/login", loginController.getLoginPage());
    }

    @Test
    void testAdmin(){
        assertEquals("admin/admin", loginController.admin());
    }
}