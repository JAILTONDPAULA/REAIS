package br.com.reais.services;

import java.util.List;
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
		Optional<Expense> p = er.findById(id);
		return p.orElseThrow(()->new NotFound("ERROR:R007S<br><br>nenhuma cadastro encontrado"));
	}
	
	public List<Expense> findAll() {
		List<Expense> lp = er.findAll();
		if(lp == null) {
			throw new NotFound("ERROR:R008S<br><br>nenhuma cadastro encontrado");
		}else {
			return lp;
		}
	}
	
	/*public Expense save(String descricao) throws IllegalAccessException {
		Expense p = new Expense(null,descricao);
		return er.save(p);
	}
	
	public Expense update(Long id,String descricao) throws IllegalAccessException  {
		Expense p = this.findById(id);
		p.setDescription(descricao);
		return er.save(p);
	}*/
	
	public void delete(Long id) {
		er.deleteById(id);
	}
}
