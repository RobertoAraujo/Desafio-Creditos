package io.github.robertoaraujo.desafio;

import io.github.robertoaraujo.desafio.controller.UsuarioController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(UsuarioController.class)
class UsuarioApplicationTests {


    @Test
    void deveRetornarListaDeUsuario() throws Exception {

    }

}