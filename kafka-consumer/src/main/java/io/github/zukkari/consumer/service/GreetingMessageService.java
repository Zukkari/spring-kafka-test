package io.github.zukkari.consumer.service;

import io.github.zukkari.consumer.data.entity.GreetingMessage;
import io.github.zukkari.consumer.data.repository.GreetingMessageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GreetingMessageService {
  private final GreetingMessageRepository repository;

  public GreetingMessageService(GreetingMessageRepository repository) {
    this.repository = repository;
  }

  public Flux<GreetingMessage> greetings() {
    return repository.findAll();
  }

  public Mono<GreetingMessage> saveMessage(String message) {
    var newMessage = new GreetingMessage(message);
    return repository.save(newMessage);
  }
}
