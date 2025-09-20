package com.fiap_api_sprint.demo.web.controller;

import com.fiap_api_sprint.demo.domain.Investimentos;
import com.fiap_api_sprint.demo.exception.RecursoNaoEncontradoException;
import com.fiap_api_sprint.demo.service.InvestimentosService;
import com.fiap_api_sprint.demo.web.dto.InvestimentosRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentosController {

    @Autowired
    private InvestimentosService investimentoService;

    @PostMapping
    public ResponseEntity<Investimentos> criar(@RequestBody @Valid InvestimentosRequest dto) {
        Investimentos investimento = new Investimentos();
        investimento.setTipo(dto.getTipo());
        investimento.setValor(dto.getValor());
        investimento.setDescricao(dto.getDescricao());

        return ResponseEntity.ok(investimentoService.salvar(investimento));
    }

    @GetMapping
    public List<Investimentos> listarTodos() {
        return investimentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investimentos> buscarPorId(@PathVariable Long id) {
        Investimentos investimento = investimentoService.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Investimento com ID " + id + " não encontrado"));
        return ResponseEntity.ok(investimento);
    }

    @PutMapping
    public ResponseEntity<Investimentos> atualizar(@RequestBody @Valid InvestimentosRequest dto, @RequestParam Long id) {
        Investimentos investimento = investimentoService.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Investimento com ID " + id + " não encontrado"));

        investimento.setTipo(dto.getTipo());
        investimento.setValor(dto.getValor());
        investimento.setDescricao(dto.getDescricao());

        return ResponseEntity.ok(investimentoService.atualizar(investimento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        investimentoService.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Investimento com ID " + id + " não encontrado"));

        investimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}