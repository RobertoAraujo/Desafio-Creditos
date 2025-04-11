package io.github.robertoaraujo.desafio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.robertoaraujo.desafio.infra.dto.CreditoDto;
import io.github.robertoaraujo.desafio.infra.model.Credito;
import io.github.robertoaraujo.desafio.service.CreditoProducer;
import io.github.robertoaraujo.desafio.service.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/creditos")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private CreditoProducer creditoProducer;

    @GetMapping(value = "/listar")
    public ResponseEntity<Page<Credito>> findAll(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {

        Pageable pageable = PageRequest.of(pagina, tamanho);
        return ResponseEntity.ok(creditoService.findAll(pageable));
    }

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<Credito>> findByNumeroNfse(@PathVariable String numeroNfse) {
        kafkaTemplate.send("creditos-events", "novo-credito", numeroNfse);
        return ResponseEntity.status(HttpStatus.OK).body(creditoService.findAllNumeroNfse(numeroNfse));
    }

    @GetMapping("credito/{numeroNfse}")
    public Credito numeroNfses(@PathVariable String numeroNfse) {
        return creditoService.findByNumeroNfse(numeroNfse);
    }

    @PostMapping(value = "/credito/criar")
    public ResponseEntity<?> criarCredito(@RequestBody CreditoDto dto) throws JsonProcessingException {
        Credito creditos = creditoService.criarCredito(dto);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String json = mapper.writeValueAsString(dto); // aqui sim você gera o JSON depois de configurar tudo
        creditoProducer.enviarMensagem(json);
        kafkaTemplate.send("creditos-events", "novo-credito", creditos);
        return ResponseEntity.ok(creditos);
    }
}
