package com.example.test9.repo;

import com.example.test9.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
//public interface UserRepository extends ReactiveCrudRepository<User, Long> {

//mongo
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Flux<User> findAllByName(String name);

    /*
    @Override
    //H2 [42102] [42S02] Таблица "USRS" не найдена
    @Query("SELECT * FROM \"users\" WHERE \"name\"='name' LIMIT 1")
    Mono<User> findById(Long id);
    */
}
