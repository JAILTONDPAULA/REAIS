package br.com.reais.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reais.entities.OriginIncome;
import br.com.reais.services.OriginIncomeService;
import br.com.reais.settings.Return;

@RestController
@RequestMapping(value="origem-receitas")
public class OriginIncomeResource {
	@Autowired
	private OriginIncomeService rs;
	
	@GetMapping
	public ResponseEntity<Return<OriginIncome>> findAll(){
		List<OriginIncome>   lr  = rs.findAll();
		Return<OriginIncome> ret = new Return<OriginIncome>(true,"OK");
		ret.setCod(lr);
		return ResponseEntity.ok().body(ret);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Return<OriginIncome>> findById(@PathVariable Long id) {
		OriginIncome receita = rs.findById(id);
		Return<OriginIncome>  ret = new Return<OriginIncome>(true,"OK");
		ret.getCod().add(receita);
		return ResponseEntity.ok().body(ret);
	}
}
