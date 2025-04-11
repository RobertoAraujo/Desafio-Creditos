package io.github.robertoaraujo.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreditoProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensagem(String mensagem) {
        kafkaTemplate.send("creditos-events", mensagem);
    }
}