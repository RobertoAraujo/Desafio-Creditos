package io.github.robertoaraujo.desafio.service;

import io.github.robertoaraujo.desafio.infra.dto.UsuarioDto;
import io.github.robertoaraujo.desafio.infra.model.Usuario;
import io.github.robertoaraujo.desafio.infra.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<Usuario> listarUsuarios(Pageable pageable) {
        return usuarioRepository.findAllBy(pageable);
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario criarUsuario(UsuarioDto dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioDto> atualizarUsuario(Long id, UsuarioDto dto) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(dto.getNome());
            usuario.setEmail(dto.getEmail());
            usuario.setSenha(dto.getSenha());

            Usuario usuarioAtualizado = usuarioRepository.save(usuario);

            // Converte para DTO (sem créditos)
            return new UsuarioDto(usuarioAtualizado.getNome(),
                    usuarioAtualizado.getEmail(), usuarioAtualizado.getSenha()
            );
        });
    }

    public boolean deletarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
