package com.fiap_api_sprint.demo.repository;


import com.fiap_api_sprint.demo.domain.Investimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestimentosRepository extends JpaRepository <Investimentos, Long> {
}
