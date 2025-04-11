package io.github.robertoaraujo.desafio.controller;

import io.github.robertoaraujo.desafio.infra.dto.CreditoDto;
import io.github.robertoaraujo.desafio.infra.model.Credito;
import io.github.robertoaraujo.desafio.infra.model.Usuario;
import io.github.robertoaraujo.desafio.service.CreditoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreditoControllerTest {

    @MockBean
    private CreditoService mockCreditoService;

    private Credito credito1;
    private Credito credito2;
    private String numeroNfes;

    @BeforeEach
    void setUp() {
        numeroNfes = "7891013";

        credito1 = new Credito();
        credito1.setNumeroNfse(numeroNfes);

        credito2 = new Credito();
        credito2.setNumeroNfse(numeroNfes);
    }

    @Test
    void buscaNumeroNfesRetornaLista() {
        List<Credito> listaSimulada = Arrays.asList(credito1, credito2);

        when(mockCreditoService.findAllNumeroNfse(numeroNfes)).thenReturn(listaSimulada);

        List<Credito> resultado = mockCreditoService.findAllNumeroNfse(numeroNfes);

        // Verificações
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals(numeroNfes, resultado.get(0).getNumeroNfse());
    }

    @Test
    void buscaNumeroNfesFalha() {

    }

    @Test
    void buscaNumeroNfesSemNfe() {

    }
}
