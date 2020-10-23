package io.github.zukkari.consumer.data.entity;

import org.springframework.data.annotation.Id;

public class GreetingMessage {

  @Id private Long id;

  private final String message;

  public GreetingMessage(String message) {
    this.message = message;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "GreetingMessage{" + "id=" + id + ", message='" + message + '\'' + '}';
  }
}
