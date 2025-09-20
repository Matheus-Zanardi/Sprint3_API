package com.fiap_api_sprint.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sprint_investimentos")
public class Investimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private Double valor;
    private String descricao;

    // Construtor vazio (necessário para o JPA)
    public Investimentos() {
    }

    // Construtor cheio (opcional, útil em testes)
    public Investimentos(Long id, String tipo, Double valor, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
