package io.github.zukkari.consumer.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GreetingListener {
  private static final Logger log = LogManager.getLogger(GreetingListener.class);

  private final GreetingMessageService service;

  public GreetingListener(GreetingMessageService service) {
    this.service = service;
  }

  @KafkaListener(topics = "greetingTopic", groupId = "consumerGroup1")
  public void onMessage(String message) {
    log.info("Received message: {}", message);
    service
        .saveMessage(message)
        .subscribe(
            msg -> log.info("Message saved: {}", msg));
  }
}
