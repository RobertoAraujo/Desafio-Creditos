package io.github.robertoaraujo.desafio.infra.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UsuarioDto {
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;
    @NotNull(message = "Email não pode ser nulo")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email inválido")
    private String email;
    @NotNull(message = "Senha não pode ser nula")
    private String senha;

    public UsuarioDto(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
