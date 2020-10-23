package io.github.zukkari.producer.service;

import io.github.zukkari.producer.config.KafkaTopic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class GreetingService {
  private static final Logger log = LogManager.getLogger(GreetingService.class);

  private final KafkaTemplate<String, String> kafkaTemplate;

  public GreetingService(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void greet(String name) {
    final var future =
        kafkaTemplate.send(KafkaTopic.GREETING_TOPIC.getName(), "Hello, " + name + "!");

    future.addCallback(
        new ListenableFutureCallback<>() {
          @Override
          public void onFailure(Throwable throwable) {
            log.error("Failed to send message to cluster", throwable);
          }

          @Override
          public void onSuccess(SendResult<String, String> stringStringSendResult) {
            log.info("Message successfully sent to cluster: {}", name);
          }
        });
  }
}
