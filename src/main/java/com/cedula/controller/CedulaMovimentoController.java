package com.cedula.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cedula.model.CedulaMovimento;
import com.cedula.service.CedulaMovimentoService;

@RestController
public class CedulaMovimentoController {
	
	@Autowired
	CedulaMovimentoService cedulaMovimentoService;
	
	@RequestMapping(method=RequestMethod.POST, value="/cedula-movimentos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CedulaMovimento>Salvar(@RequestBody CedulaMovimento cedulaMovimento) {
		
		CedulaMovimento alterado = cedulaMovimentoService.Salvar(cedulaMovimento);
		return new ResponseEntity<CedulaMovimento>(alterado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cedula-movimentos", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<CedulaMovimento>> BuscarTodos() {
		
		return new ResponseEntity<>(cedulaMovimentoService.BuscarTodos(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/cedula-movimentos/{id}")
	public ResponseEntity<String> Excluir(@PathVariable Integer id) {
		
		CedulaMovimento cedulaMovimento = cedulaMovimentoService.BuscarPorId(id);
		cedulaMovimentoService.Excluir(cedulaMovimento);
		if(cedulaMovimento == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/cedula-movimentos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CedulaMovimento> Alterar(@RequestBody CedulaMovimento cedulaMovimento) {
		
		return new ResponseEntity<>(cedulaMovimentoService.Salvar(cedulaMovimento), HttpStatus.OK);
	}

}
