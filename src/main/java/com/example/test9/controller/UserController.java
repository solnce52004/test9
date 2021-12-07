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
    public Mono<User> userById(
//            @PathVariable("id") Long id
            @PathVariable("id") String id //mongo
    ) {
        return userService.findById(id);
    }
    //mongo
    @GetMapping("/name/{name}")
    public Flux<User> findAllByAdminName( @PathVariable("name") String name  ) {
        return userService.findAllByName(name);
    }

    @PostMapping
    public Mono<User> save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(
//            @PathVariable("id") Long id
            @PathVariable("id") String id
    ) {
        return userService.deleteById(id);
    }
}
