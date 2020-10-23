package io.github.zukkari.producer.controller;

import io.github.zukkari.producer.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
  private final GreetingService greetingService;

  @Autowired
  public GreetingController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @GetMapping("/greet/{name}")
  public String greet(@PathVariable("name") String name) {
    greetingService.greet(name);
    return name;
  }
}
