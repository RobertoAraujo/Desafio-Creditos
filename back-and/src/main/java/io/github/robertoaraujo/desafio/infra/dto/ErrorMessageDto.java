package io.github.robertoaraujo.desafio.infra.dto;

public class ErrorMessageDto {
    private String mensagemErro;

    public ErrorMessageDto(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

}