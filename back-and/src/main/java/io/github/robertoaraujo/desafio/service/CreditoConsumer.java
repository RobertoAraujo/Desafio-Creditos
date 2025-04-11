package io.github.robertoaraujo.desafio.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CreditoConsumer {

    @KafkaListener(topics = "${topico.credito}", groupId = "credito-group")
    public void consumirCredito(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
        // Adicione sua lógica de processamento aqui
    }
}