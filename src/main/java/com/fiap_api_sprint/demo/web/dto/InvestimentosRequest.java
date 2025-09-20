package com.fiap_api_sprint.demo.web.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class InvestimentosRequest {

    @NotBlank(message = "O tipo do investimento é obrigatório")
    private String tipo;

    @NotNull(message = "O valor do investimento é obrigatório")
    private Double valor;

    private String descricao;

    // Construtor vazio (necessário para o Spring usar @RequestBody)
    public InvestimentosRequest() {
    }

    // Construtor cheio (opcional, útil em testes)
    public InvestimentosRequest(String tipo, Double valor, String descricao) {
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}