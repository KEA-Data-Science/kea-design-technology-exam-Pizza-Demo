package edu.kea.exam.pizza.demo.controllers;
import edu.kea.exam.pizza.demo.controller.CardController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
class CardControllerTest {

    private MockMvc mockMvc;

    @Autowired
    CardController cardController;  //test subject


    // testcase 1
    @Test
    void showCard() throws Exception{
        assertThat(cardController).isNotNull();


    }
}
