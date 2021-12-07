package com.example.test9.service;

import com.example.test9.entity.User;
import com.example.test9.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    //    public Mono<User> findById(Long id){
    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

//    public Mono<Void> deleteById(Long id) {
    public Mono<Void> deleteById(String id) {
        return userRepository.deleteById(id);
    }

    public Flux<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }
}
