package edu.kea.exam.pizza.demo.controllers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class HttpRequestTest {


@LocalServerPort
    private int port;

@Autowired
    private TestRestTemplate restTemplate;

@Test
    public void homePageReturnsVersionNumberCorrectly_thenSucces(){
    String renderedHtml = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
    assertEquals(renderedHtml.contains("3.3.3"), true);

    }
}
