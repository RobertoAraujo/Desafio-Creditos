package io.github.robertoaraujo.desafio.servico;

import io.github.robertoaraujo.desafio.infra.model.Credito;
import io.github.robertoaraujo.desafio.service.CreditoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreditoServiceTest {

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
        // Simulando uma lista vazia
        when(mockCreditoService.findAllNumeroNfse(numeroNfes)).thenReturn(Collections.emptyList());

        List<Credito> resultado = mockCreditoService.findAllNumeroNfse(numeroNfes);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty(), "A lista deve estar vazia quando não há resultados");
    }

    @Test
    void buscaUmNumeroNfes() {
        String numeroNfes = "123456789";
        Credito credito = new Credito();
        credito.setNumeroNfse(numeroNfes);

        when(mockCreditoService.findByNumeroNfse(numeroNfes)).thenReturn(credito);

        Credito resultado = mockCreditoService.findByNumeroNfse(numeroNfes);

        assertNotNull(resultado);
        assertEquals(numeroNfes, resultado.getNumeroNfse());
    }

    @Test
    void salvaCredito() {

    }
}
