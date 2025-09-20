package com.fiap_api_sprint.demo.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "sprint_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    private String cpf;

    // Construtor vazio (necessário para JPA)
    public Cliente() {
    }

    // Construtor cheio (opcional, útil para testes)
    public Cliente(Long id, String nome, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
