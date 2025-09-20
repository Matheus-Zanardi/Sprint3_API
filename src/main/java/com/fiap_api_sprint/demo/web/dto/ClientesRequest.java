package com.fiap_api_sprint.demo.web.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ClientesRequest {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "O email deve ser válido")
    private String email;

    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos")
    private String cpf;

    // Construtor vazio (necessário para o Spring usar @RequestBody)
    public ClientesRequest() {
    }

    // Construtor cheio (opcional, útil em testes)
    public ClientesRequest(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    // Getters e Setters manuais
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