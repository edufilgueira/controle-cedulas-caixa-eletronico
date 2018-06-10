package com.cedula.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cedula.model.Cedula;
import com.cedula.repository.CedulaRepository;



@Service
public class CedulaService {
	
	@Autowired
	CedulaRepository cedulaRepository; 

	public Cedula Salvar(Cedula cedula) {

		cedulaRepository.save(cedula);
		return cedula;
	}
	
	public Collection<Cedula> BuscarTodos() {
		return  cedulaRepository.findAll();
	}
	
	public void Excluir(Cedula cedula) {
		cedulaRepository.delete(cedula);
	}
	
	public Cedula BuscarPorId(Integer id) {
		return cedulaRepository.findOne(id); 
	}
	
	public Cedula findByValor(Integer valor) {
		return cedulaRepository.findByValor(valor);
	}
	
	public ArrayList<Integer> BuscarTodosIds() {
		
		ArrayList<Integer> IDS = new ArrayList<>();
		
		Collection<Cedula> cedulas = cedulaRepository.findAll();
		for(Cedula cedula : cedulas) {
			IDS.add(cedula.getValor());
		}
		
		return IDS;
	}
	
	public Map<Integer, Integer> BuscarEstoque() {
		
		Map<Integer, Integer> estoque = new HashMap<>();
		
		Collection<Cedula> cedulas = cedulaRepository.findAll();
		for(Cedula cedula : cedulas) {
			estoque.put(cedula.getValor(), cedula.getEstoque());
		}
		
		return estoque;
	}
}
