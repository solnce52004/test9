package com.example.test9.service;

import com.example.test9.entity.User;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@AllArgsConstructor
public class UserByMongoTemplateService {
    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private final RoleService roleService;

    public Flux<User> findAll() {
        return reactiveMongoTemplate.findAll(User.class);
    }

    public Mono<User> findById(String id) {
        return reactiveMongoTemplate.findById(id, User.class);
    }

    public Mono<User> save(User user) {
        return reactiveMongoTemplate.save(user);
    }

    public Mono<UpdateResult> upsert(String id, User user) {
        return reactiveMongoTemplate
                .update(User.class)
                .matching(query(Criteria
                        .where("id").is(id)
                        .and("email").is(user.getEmail())
                        .and("name").is(user.getName())
                ))
                .apply(Update.update("password", user.getPassword()))
                .upsert();
    }

    public Mono<Void> deleteById(String id) {
        return reactiveMongoTemplate.remove(findById(id)).then();
    }

    public Flux<User> findAllByName(String name) {
        final Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("name").in(name))
        );
        return reactiveMongoTemplate.aggregate(aggregation, User.class, User.class);
    }
}
