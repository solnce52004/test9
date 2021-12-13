package com.example.test9.service;

import com.example.test9.TestConfig;
import com.example.test9.entity.User;
import com.example.test9.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Mono;

@SpringBootTest
@TestPropertySource("classpath:test-application.properties")
@Import(TestConfig.class)
class UserServiceTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void findAll() {
       userRepository.findAll()
               .subscribe(System.out::println);
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
        final User user = new User();
        user.setName("admin")
        .setEmail("admin@a.com").
        setPassword("qwer");

        final Mono<User> save = userRepository.save(user);
        save.subscribe(System.out::println);
    }

    @Test
    void deleteById() {
    }
}