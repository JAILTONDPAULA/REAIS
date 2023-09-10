package br.com.reais.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reais.entities.OriginIncome;
import br.com.reais.exceptions.NotFound;
import br.com.reais.repositories.OriginIncomeRepository;

@Service
public class OriginIncomeService {
	@Autowired
	private OriginIncomeRepository conn;
		
	public OriginIncome findById(Long id) {
		Optional<OriginIncome> revenue = conn.findById(id);
		return revenue.orElseThrow(()->new NotFound("ERROR:R002BE<br>Receita não encontrada"));
	}
	
	public List<OriginIncome> findAll(){
		List<OriginIncome> list = conn.findAll();
		if(list == null) {
			new NotFound("ERROR:R005BE<br>Receitas não encontrada");
		}
		return list;
	}
	
	public List<String> listDescrition() {
		List<OriginIncome> list = conn.findAll();
		if(list == null) {
			new NotFound("ERROR:R006BE-EOI<br>Receitas não encontrada");
		}
		List<String> descricoes = new ArrayList<>();
		
		for (OriginIncome x : list) {
			descricoes.add(x.getDescription());
		}
		
		return descricoes;
	}
}
