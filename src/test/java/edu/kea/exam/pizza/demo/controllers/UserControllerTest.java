package edu.kea.exam.pizza.demo.controllers;
import edu.kea.exam.pizza.demo.controller.UserController;
import edu.kea.exam.pizza.demo.security.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserControllerTest{

    @Mock
    UserRepository userRepo;

    UserController userController;

    @BeforeEach
    void setUp(){
        userRepo = mock(UserRepository.class);
        userController = new UserController(userRepo);

    }

    @Test
    void testNewSignUp(){
        assertEquals("user/sign-up", userController.newSignUp());
    }

    @Test
    void testNewSignUpSave(){
        System.out.println();
    }
}
