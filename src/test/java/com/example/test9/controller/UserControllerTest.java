package com.example.test9.controller;

import com.example.test9.repo.UserRepository;
import com.example.test9.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

@WebFluxTest(UserController.class)
@TestPropertySource("classpath:test-application.properties")
//@Import(TestConfig.class)
class UserControllerTest {

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserService userService;
    @Autowired
    private UserController userController;

    @Test
    void all() {
        System.out.println("dfdfbdb");
    }

    @Test
    void part() {
    }

    @Test
    void userById() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }
}