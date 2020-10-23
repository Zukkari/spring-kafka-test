package io.github.zukkari.producer.config;

import org.apache.kafka.clients.admin.NewTopic;

public enum KafkaTopic {
  GREETING_TOPIC("greetingTopic", 1, (short) 1);

  private final String name;
  private final int partitions;
  private final short replicas;

  KafkaTopic(String name, int partitions, short replicas) {
    this.name = name;
    this.partitions = partitions;
    this.replicas = replicas;
  }

  public NewTopic asTopic() {
    return new NewTopic(name, partitions, replicas);
  }

  public String getName() {
    return name;
  }
}
