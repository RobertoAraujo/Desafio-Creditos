package io.github.robertoaraujo.desafio.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreditoProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

//    @Value("${topico.credito}")
    private String topicoCredito;

    public CreditoProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarCredito(String creditoJson) {
        kafkaTemplate.send(topicoCredito, creditoJson);
    }
}