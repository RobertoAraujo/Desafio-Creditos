package io.github.robertoaraujo.desafio.controller;

import io.github.robertoaraujo.desafio.infra.dto.UsuarioDto;
import io.github.robertoaraujo.desafio.infra.model.Usuario;
import io.github.robertoaraujo.desafio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario/listar")
    public ResponseEntity<Page<Usuario>> listarUsuarios(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {

        Pageable pageable = PageRequest.of(pagina, tamanho);
        return ResponseEntity.ok(usuarioService.listarUsuarios(pageable));
    }

    @GetMapping(value = "/buscar/{email}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable String email) {
        return usuarioService.buscarUsuarioPorEmail(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/usuario/id/{id}")
    public ResponseEntity<Usuario> buscarUsuarioId(@PathVariable Long id) {
        return usuarioService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/usuario/criar")
    public ResponseEntity<UsuarioDto> criarUsuario(@Valid @RequestBody UsuarioDto dto) {
        Usuario usuario = usuarioService.criarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioDto(usuario.getNome(), usuario.getEmail(), usuario.getSenha()));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<UsuarioDto> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDto dto) {
        return usuarioService.atualizarUsuario(id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        if (usuarioService.deletarUsuario(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
