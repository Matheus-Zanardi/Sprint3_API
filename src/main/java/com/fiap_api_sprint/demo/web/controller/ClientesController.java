package com.fiap_api_sprint.demo.web.controller;


import com.fiap_api_sprint.demo.domain.Cliente;
import com.fiap_api_sprint.demo.exception.RecursoNaoEncontradoException;
import com.fiap_api_sprint.demo.service.ClienteService;
import com.fiap_api_sprint.demo.web.dto.ClientesRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody @Valid ClientesRequest dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setCpf(dto.getCpf());

        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente com ID " + id + " não encontrado"));
        return ResponseEntity.ok(cliente);
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizar(@RequestBody @Valid ClientesRequest dto, @RequestParam Long id) {
        Cliente cliente = clienteService.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente com ID " + id + " não encontrado"));

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setCpf(dto.getCpf());

        return ResponseEntity.ok(clienteService.atualizar(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente com ID " + id + " não encontrado"));

        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}