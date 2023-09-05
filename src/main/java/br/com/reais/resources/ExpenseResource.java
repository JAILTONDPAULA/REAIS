package br.com.reais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reais.entities.Expense;
import br.com.reais.services.ExpenseService;
import br.com.reais.settings.Return;

@RestController
@RequestMapping(value = "despesas")
public class ExpenseResource {
	@Autowired
	private ExpenseService es;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Return<Expense>> findById(@PathVariable Long id){
		Return<Expense> returns = new Return<>(true,"ok");
		returns.getCod().add(es.findById(id));
		return ResponseEntity.ok().body(returns);
	}
}
