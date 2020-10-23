package io.github.zukkari.consumer.data.repository;

import io.github.zukkari.consumer.data.entity.GreetingMessage;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingMessageRepository extends ReactiveCrudRepository<GreetingMessage, Long> {}
