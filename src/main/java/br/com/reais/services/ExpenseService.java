package br.com.reais.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reais.entities.Expense;
import br.com.reais.exceptions.NotFound;
import br.com.reais.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository er;
	
	public Expense findById(Long id) {
		Optional<Expense> desepesa = er.findById(id);
		return desepesa.orElseThrow(()->new NotFound("ERROR:R004BE<br>Despesa não encontrada"));
	}
}
