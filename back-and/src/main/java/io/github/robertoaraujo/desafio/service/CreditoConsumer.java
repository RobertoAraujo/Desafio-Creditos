package io.github.robertoaraujo.desafio.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CreditoConsumer {

//    @KafkaListener(topics = "${topico.credito}", groupId = "credito-group")
    public void consumirCredito(String mensagem) {
        System.out.println("Recebido do Kafka: " + mensagem);
        // processa o JSON aqui
    }
}