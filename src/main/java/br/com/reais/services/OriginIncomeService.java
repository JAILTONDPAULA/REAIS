package br.com.reais.services;

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
	
	public List<OriginIncome> findAll(){
		return conn.findAll();
	}
	
	public OriginIncome findById(Long id) {
		Optional<OriginIncome> revenue = conn.findById(id);
		return revenue.orElseThrow(()->new NotFound("ERROR:R0021BE<br>Receita não encontrada"));
	}
}
