package com.example.test9.repo;

import com.example.test9.entity.Role;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RoleRepository  extends ReactiveMongoRepository<Role, String> {
     Mono<Role> findByTitle(String title);
}
