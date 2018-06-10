package com.cedula.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedula.model.CedulaMovimento;
import com.cedula.repository.CedulaMovimentoRepository;


@Service
public class CedulaMovimentoService {
	
	
	@Autowired
	CedulaMovimentoRepository CedulaMovimentoRepository;
	
	public CedulaMovimento Salvar(CedulaMovimento cedulaMovimento) {

		CedulaMovimentoRepository.save(cedulaMovimento);
		return cedulaMovimento;
	}
	
	public Collection<CedulaMovimento> BuscarTodos() {
		return  CedulaMovimentoRepository.findAll();
	}
	
	public void Excluir(CedulaMovimento cedulaMovimento) {
		CedulaMovimentoRepository.delete(cedulaMovimento);
	}
	
	public CedulaMovimento BuscarPorId(Integer id) {
		return CedulaMovimentoRepository.findOne(id); 
	}

}
