package com.cedula.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cedula.model.Cedula;
import com.cedula.model.CedulaMovimento;
import com.cedula.service.CalcularCombinacaoService;
import com.cedula.service.CedulaMovimentoService;
import com.cedula.service.CedulaService;

@RestController
public class CalcularCombinacaoController {
	
	@Autowired
	CalcularCombinacaoService calcularCombinacaoService;
	
	@Autowired
	CedulaService cedulaService;
	
	@Autowired
	CedulaMovimentoService cedulaMovimentoService;
	
	@RequestMapping(method=RequestMethod.POST, value="/sacar")
	public String sacar(@RequestBody Map<String, String> notas) {
			
		/*for (Entry<String, String> quantidadeNota : notas.entrySet()) {
			Integer valorNota = Integer.valueOf(quantidadeNota.getKey());
			Integer quantidade = Integer.valueOf(quantidadeNota.getValue());
					
			Cedula cedula = cedulaService.findByValor(valorNota);
			cedula.diminuirEstoque(quantidade);
			cedulaService.Salvar(cedula);
			
			CedulaMovimento cedulaMovimento = new CedulaMovimento();
			cedulaMovimento.setCedula(cedula);
			cedulaMovimento.setQuantidade(quantidade);
			cedulaMovimento.setTipoEntrada("d");
			cedulaMovimento.setDataentrada(new Date());
			
			cedulaMovimentoService.Salvar(cedulaMovimento);
		}*/
		
		
		
		return "Sucesso "+notas;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/calcular")
	public List<Map<Integer, Long>> gerarPossivilidadesDeCedula(@RequestBody int valorSaque) {
		
		
		ArrayList<Integer> IDS = cedulaService.BuscarTodosIds();
		
		Stack<Integer> sol = new Stack<>();
		List<Integer[]> solucoes = new ArrayList<>();
		Map<Integer, Integer> estoque = cedulaService.BuscarEstoque();
		
		calcularCombinacaoService.calcularCombinacao(valorSaque, IDS, sol, solucoes);
		
		List<Map<Integer, Long>> notasAgrupadas = new ArrayList<>();
		
		
		
		for (Integer [] combinacao : solucoes) {
			List<Integer> combinacaoList = Arrays.asList(combinacao);
			Map<Integer, Long> quantidadePorNotas =
					combinacaoList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
			
			System.out.println("estoque: " + Collections.singletonList(estoque));
			System.out.println("quantidadePorNotas: " + Collections.singletonList(quantidadePorNotas));
			
			if (quantidadePorNotas.size() <= 3) {
				
				boolean disponivelEmEstoque = true;
				
				for (Entry<Integer, Long> quantidadeDaNota : quantidadePorNotas.entrySet()) {
					Integer nota = quantidadeDaNota.getKey();
					
					Integer estoqueNota = estoque.get(nota);
					Long quantidadeSolicitada = quantidadeDaNota.getValue();
					
					if (quantidadeSolicitada > estoqueNota) {
						disponivelEmEstoque = false;
					}
				}
				
				if (disponivelEmEstoque) {
					notasAgrupadas.add(quantidadePorNotas);
				}
			}
		}

		return notasAgrupadas;
	}

}
