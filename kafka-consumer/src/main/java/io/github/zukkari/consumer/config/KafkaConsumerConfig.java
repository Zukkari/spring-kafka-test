package io.github.zukkari.consumer.config;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

  private final String bootstrapAddress;
  private final String groupId;

  @Autowired
  public KafkaConsumerConfig(
      @Value("${kafka.boostrapAddress}") String bootstrapAddress,
      @Value("${kafka.groupId}") String groupId) {
    this.bootstrapAddress = bootstrapAddress;
    this.groupId = groupId;
  }

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    var props =
        Map.<String, Object>of(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
            bootstrapAddress,
            ConsumerConfig.GROUP_ID_CONFIG,
            groupId,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
            StringDeserializer.class,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
            StringDeserializer.class);

    return new DefaultKafkaConsumerFactory<>(props);
  }
}
