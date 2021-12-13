package com.example.test9.service;

import com.example.test9.entity.Role;
import com.example.test9.repo.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Mono<Role> save(Role role){
        return roleRepository.save(role);
    }

    public Mono<Role> findById(String id){
        return roleRepository.findById(id);
    }

    public Mono<Role> findByTitle(String title){
        return roleRepository.findByTitle(title);
    }
}
