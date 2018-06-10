package com.cedula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cedula.model.CedulaMovimento;


@Repository
public interface CedulaMovimentoRepository extends JpaRepository<CedulaMovimento, Integer>{

}