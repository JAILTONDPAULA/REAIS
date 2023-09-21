package br.com.reais.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reais.services.BrandService;
import br.com.reais.settings.Return;

@RestController
@RequestMapping(value = "marcas")
@CrossOrigin(origins = "*")
public class BrandResource {
	
	@Autowired
	private BrandService ts;
	
	@GetMapping(value = "/descricao")
	public ResponseEntity<Return<String>> list() {
		List<String> ls  = ts.list();
		Return<String> r = new Return<>(true,"ok");
		r.setCod(ls);
		return ResponseEntity.ok().body(r);
	}
}
