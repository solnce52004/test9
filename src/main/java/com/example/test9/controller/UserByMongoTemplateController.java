package com.example.test9.controller;

import com.example.test9.entity.Role;
import com.example.test9.entity.User;
import com.example.test9.service.RoleService;
import com.example.test9.service.UserByMongoTemplateService;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/tmpl/user")
@AllArgsConstructor
public class UserByMongoTemplateController {
    private final UserByMongoTemplateService userByMongoTemplateService;
    private final RoleService roleService;

    @GetMapping
    public Flux<User> all() {
        return userByMongoTemplateService.findAll();
    }

    @GetMapping("/part")
    public Flux<User> part(
            @RequestParam(value = "skip", defaultValue = "1") Long skipCount,
            @RequestParam(value = "to", defaultValue = "3") Long toId
    ) {
        return userByMongoTemplateService
                .findAll()
                .skip(skipCount)
                .take(toId);
    }

    @GetMapping("/{id}")
    public Mono<User> userById(@PathVariable("id") String id) {
        return userByMongoTemplateService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Flux<User> findAllByAdminName(@PathVariable("name") String name) {
        return userByMongoTemplateService.findAllByName(name);
    }

//    @GetMapping("/name/")
//    public Flux<User> findNames() {
//        return userServiceByMongoTemplate.findDistinctNames();
//    }

    @PatchMapping("/{id}")
    public Mono<UpdateResult> upsertPassword(
            @PathVariable("id") String id,
            @RequestBody User user
    ) {
        return userByMongoTemplateService.upsert(id, user);
    }

    @PostMapping
    public Mono<User> save(@RequestBody User user) {
        return userByMongoTemplateService.save(user);
    }

    @PostMapping("/role")
    public Mono<Role> save(@RequestBody Role role) {
        return roleService.save(role);
    }

    @PostMapping("/with-roles")
    public Mono<User> saveWithRole(@RequestBody User user) {
        Set<Role> roles = new HashSet<>();

        return Flux.fromIterable(user.getRoles())
                .flatMap(r -> roleService.findByTitle(r.getTitle()).defaultIfEmpty(r))
                .map(r -> {
                    if (r.getId() != null) {
                        roles.add(r);
                    } else {
                        roleService.save(r).subscribe(roles::add);
                    }
                    System.out.println(r);
                    return r;
                })
                .map(r -> user.setRoles(roles))
                .then(userByMongoTemplateService.save(user));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") String id) {
        return userByMongoTemplateService.deleteById(id);
    }
}