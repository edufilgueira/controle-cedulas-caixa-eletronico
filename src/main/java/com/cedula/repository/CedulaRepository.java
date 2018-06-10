package com.cedula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cedula.model.Cedula;

@Repository
public interface CedulaRepository extends JpaRepository<Cedula, Integer>{
	 
	@Query("select c from Cedula c where c.valor = ?1")
	Cedula findByValor(Integer valor);
}

