package br.com.reais.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reais.entities.Cost;
import br.com.reais.repositories.CostRepository;

@Service
public class CostService {
	@Autowired
	private CostRepository cr;
	
	public List<Cost> findAll() {
		return cr.findAllByOrderByDescription();
	}
	
	public List<String> list() {
		List<Cost>   lc   = this.findAll();
		List<String> list = new ArrayList<>();
		for (Cost cost : lc) {
			list.add(cost.getDescription());
		}
		
		return list;
	}

}
