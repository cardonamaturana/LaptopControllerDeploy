package com.example.OpenBootcampCrudApiRest.Controller;

import com.example.OpenBootcampCrudApiRest.Entity.LaptopEntity;
import com.example.OpenBootcampCrudApiRest.OpenBootcampCrudApiRestApplication;
import com.example.OpenBootcampCrudApiRest.Repository.LaptopRepository;
import com.sun.istack.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.service.Header;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port ;



    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);

    }

    @BeforeAll
    static void setUpAll(){

    }

    @DisplayName("Testeando findAll")
    @Test
    void findAll() {
        ResponseEntity<LaptopEntity[]> response =  testRestTemplate.getForEntity("/app/laptops",
                LaptopEntity[].class);
        List<LaptopEntity> list = Arrays.asList(response.getBody());

        //Probando el tipo de respuesta debido a que hay 2 Laptop creadas con el metodo Create
        assertEquals(HttpStatus.OK, response.getStatusCode());




    }

    @Test
    void findById() {
        ResponseEntity<LaptopEntity> response =  testRestTemplate.getForEntity("/app/laptop/0",
                LaptopEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        ResponseEntity<LaptopEntity> responseOne;

        String route = "/app/laptop";

        String json1 = """
                {
                    "model": "Galaxy S5",
                    "date": "01/03/1996",
                    "brand": "Samsung"
                }""";


        HttpEntity<String> request1 = new HttpEntity<>(json1, headers);

        responseOne = testRestTemplate.exchange(route, HttpMethod.POST, request1, LaptopEntity.class);

        assertEquals(HttpStatus.OK, responseOne.getStatusCode());

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void isNull() {
    }
}