package br.com.reais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reais.entities.Revenue;
import br.com.reais.exceptions.NotFound;
import br.com.reais.repositories.RevenueRepository;

@Service
public class RevenueService {
	@Autowired
	private RevenueRepository conn;
	
	public Revenue findById(Long id) {
		Optional<Revenue> revenue = conn.findById(id);
		return revenue.orElseThrow(()->new NotFound("ERROR:R001BE<br>Receita não encontrada"));
	}	
	
	public List<Revenue> findAll(){
		List<Revenue> list = conn.findAll();
		
		if(list == null) {
			new NotFound("ERROR:R006BE<br>Receitas não encontrada");
		}
		
		return list;
	}
}
