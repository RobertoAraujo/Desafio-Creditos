package io.github.robertoaraujo.desafio.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class CreditoTopic {

    @Bean
    public NewTopic criarTopic() {
        return TopicBuilder.name("topico-creditos").partitions(1).replicas(1).build();
    }
}
