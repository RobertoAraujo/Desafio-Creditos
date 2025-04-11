package io.github.robertoaraujo.desafio.controller;

import io.github.robertoaraujo.desafio.infra.model.Credito;
import io.github.robertoaraujo.desafio.service.CreditoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class CreditoControllerTest  {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditoService creditoService;

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
    void deveRetornarListaDeCreditosPorNumeroNfse() throws Exception {
        List<Credito> listaSimulada = Arrays.asList(credito1, credito2);

        when(creditoService.findAllNumeroNfse(numeroNfes)).thenReturn(listaSimulada);

        mockMvc.perform(get("/api/creditos/" + numeroNfes)) // Ajuste a URL conforme seu endpoint real
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].numeroNfse").value(numeroNfes));
    }

    @Test
    void deveRetornarCreditoUnicoPorNumeroNfse() throws Exception {
        String numeroNfse = "123456789";
        Credito credito = new Credito();
        credito.setNumeroNfse(numeroNfse);

        when(creditoService.findByNumeroNfse(numeroNfse)).thenReturn(credito);

        mockMvc.perform(get("/api/creditos/credito/" + numeroNfse))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroNfse").value(numeroNfse));
    }
}