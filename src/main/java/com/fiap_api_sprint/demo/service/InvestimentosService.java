package com.fiap_api_sprint.demo.service;


import com.fiap_api_sprint.demo.domain.Investimentos;
import com.fiap_api_sprint.demo.repository.InvestimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestimentosService {

    @Autowired
    private InvestimentosRepository investimentoRepository;

    public Investimentos salvar(Investimentos investimento) {
        return investimentoRepository.save(investimento);
    }

    public List<Investimentos> listarTodos() {
        return investimentoRepository.findAll();
    }

    public Optional<Investimentos> buscarPorId(Long id) {
        return investimentoRepository.findById(id);
    }

    public void deletar(Long id) {
        investimentoRepository.deleteById(id);
    }

    public Investimentos atualizar(Investimentos investimento) {
        return investimentoRepository.save(investimento);
    }
}
