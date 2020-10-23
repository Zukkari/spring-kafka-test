package io.github.zukkari.consumer.web;

import io.github.zukkari.consumer.data.entity.GreetingMessage;
import io.github.zukkari.consumer.service.GreetingMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class GreetingMessageController {
  private final GreetingMessageService service;

  public GreetingMessageController(GreetingMessageService service) {
    this.service = service;
  }

  @GetMapping("/greetings")
  public Flux<GreetingMessage> greetings() {
    return service.greetings();
  }
}
