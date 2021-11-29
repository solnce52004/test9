package com.example.test9.controller;

import com.example.test9.entity.User;
import com.example.test9.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public Flux<User> all() {
        return userService.findAll();
    }

    @GetMapping("/part")
    public Flux<User> part(
            @RequestParam(value = "skip", defaultValue = "1") Long skipCount,
            @RequestParam(value = "to", defaultValue = "3") Long toId
    ) {
        return userService
                .findAll()
                .skip(skipCount)
                .take(toId);
    }

    @GetMapping("/{id}")
    public Mono<User> userById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public Mono<User> save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }
}
