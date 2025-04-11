package io.github.robertoaraujo.desafio.infra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.robertoaraujo.desafio.infra.model.Credito;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditoDto {
    @NotNull(message = "Descrição não pode ser nula")
    private String numeroCredito;
    @NotNull(message = "numeroNfse não pode ser nulo")
    private String numeroNfse;
    @NotNull(message = "Data de constituição não pode ser nula")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataConstituicao;
    @NotNull(message = "Valor não pode ser nulo")
    private BigDecimal valorIssqn;
    @NotNull(message = "Tipo de crédito não pode ser nulo")
    private String tipoCredito;
    @NotNull(message = "Simples Nacional não pode ser nulo")
    private boolean simplesNacional;
    @NotNull(message = "Alíquota não pode ser nula")
    private BigDecimal aliquota;
    @NotNull(message = "Valor faturado não pode ser nulo")
    private BigDecimal valorFaturado;
    @NotNull(message = "Valor de dedução não pode ser nulo")
    private BigDecimal valorDeducao;
    @NotNull(message = "Base de cálculo não pode ser nula")
    private BigDecimal baseCalculo;
    @NotNull(message = "Usuário não pode ser nulo")
    @JsonProperty("usuario_id")
    private Long usuarioId;

    public CreditoDto() {
    }

    public CreditoDto(String numeroCredito, String numeroNfse, LocalDate dataConstituicao, BigDecimal valorIssqn,
                      String tipoCredito, boolean simplesNacional, BigDecimal aliquota, BigDecimal valorFaturado,
                      BigDecimal valorDeducao, BigDecimal baseCalculo, Long usuarioId) {
        this.numeroCredito = numeroCredito;
        this.numeroNfse = numeroNfse;
        this.dataConstituicao = dataConstituicao;
        this.valorIssqn = valorIssqn;
        this.tipoCredito = tipoCredito;
        this.simplesNacional = simplesNacional;
        this.aliquota = aliquota;
        this.valorFaturado = valorFaturado;
        this.valorDeducao = valorDeducao;
        this.baseCalculo = baseCalculo;
        this.usuarioId = usuarioId;
    }

    public String getNumeroCredito() {
        return numeroCredito;
    }

    public void setNumeroCredito(String numeroCredito) {
        this.numeroCredito = numeroCredito;
    }

    public String getNumeroNfse() {
        return numeroNfse;
    }

    public void setNumeroNfse(String numeroNfse) {
        this.numeroNfse = numeroNfse;
    }

    public LocalDate getDataConstituicao() {
        return dataConstituicao;
    }

    public void setDataConstituicao(LocalDate dataConstituicao) {
        this.dataConstituicao = dataConstituicao;
    }

    public BigDecimal getValorIssqn() {
        return valorIssqn;
    }

    public void setValorIssqn(BigDecimal valorIssqn) {
        this.valorIssqn = valorIssqn;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public boolean isSimplesNacional() {
        return simplesNacional;
    }

    public void setSimplesNacional(boolean simplesNacional) {
        this.simplesNacional = simplesNacional;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public BigDecimal getValorFaturado() {
        return valorFaturado;
    }

    public void setValorFaturado(BigDecimal valorFaturado) {
        this.valorFaturado = valorFaturado;
    }

    public BigDecimal getValorDeducao() {
        return valorDeducao;
    }

    public void setValorDeducao(BigDecimal valorDeducao) {
        this.valorDeducao = valorDeducao;
    }

    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(BigDecimal baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
