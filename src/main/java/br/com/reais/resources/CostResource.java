package br.com.reais.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reais.entities.Cost;
import br.com.reais.services.CostService;
import br.com.reais.settings.Return;

@RestController
@RequestMapping(value="custos")
@CrossOrigin(origins = "*")
public class CostResource {
	@Autowired
	private CostService cs;
	
	@GetMapping(value = "/descricao")
	public ResponseEntity<Return<String>> list() {
		List<String> lc = cs.list();
		Return<String> r  = new Return<>(true,"ok");
		r.setCod(lc);
		return ResponseEntity.ok().body(r);
	}
	
	@GetMapping
	public ResponseEntity<Return<Cost>> findAll() {
		List<Cost> lc  = cs.findAll();
		Return<Cost> r = new Return<>(true,"ok");
		r.setCod(lc);
		return ResponseEntity.ok().body(r);
	}
}
