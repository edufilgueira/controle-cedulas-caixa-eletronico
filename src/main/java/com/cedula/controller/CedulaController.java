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

import com.cedula.model.Cedula;
import com.cedula.service.CedulaService;




@RestController
public class CedulaController {

	@Autowired
	CedulaService cedulaService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/cedulas", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cedula>Salvar(@RequestBody Cedula cedula) {

		Cedula alterado = cedulaService.Salvar(cedula);
		return new ResponseEntity<Cedula>(alterado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cedulas", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cedula>> BuscarTodos() {
		
		return new ResponseEntity<>(cedulaService.BuscarTodos(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/cedulas/{id}")
	public ResponseEntity<String> Excluir(@PathVariable Integer id) {
		
		Cedula cedula = cedulaService.BuscarPorId(id);
		cedulaService.Excluir(cedula);
		if(cedula == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/cedulas", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cedula> Alterar(@RequestBody Cedula cedula) {
		
		return new ResponseEntity<>(cedulaService.Salvar(cedula), HttpStatus.OK);
	}
	
	
}
