package com.cedula.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class CalcularCombinacaoService {


	public int calcularCombinacao(int N, List<Integer> moedas, Stack<Integer> sol, List<Integer[]> conj_solucoes) {
		
		if((N<0) || (moedas.size()==0)) return 0;
		if(N==0) {
			conj_solucoes.add(sol.toArray(new Integer[sol.size()]));
			return 1;
		}
		
		Integer moeda = moedas.get(0);
		sol.push(moeda);
		int v1 = calcularCombinacao(N-moeda, moedas, sol, conj_solucoes);
		sol.pop();
		
		List<Integer> moedas_novo = new ArrayList<>(moedas);
		moedas_novo.remove(moeda);
		int v2 = calcularCombinacao(N, moedas_novo, sol, conj_solucoes);
		
		return v1 + v2;
	}
}
