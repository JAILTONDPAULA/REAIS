package br.com.reais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reais.entities.Cartegory;
import br.com.reais.services.CartegoryService;
import br.com.reais.settings.Return;
import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="cartegorias")
public class CartegoryResource {
	@Autowired
	private CartegoryService ps;
	
	@GetMapping
	public ResponseEntity<Return<Cartegory>> findAll() {
		Return<Cartegory> r = new Return<>(true,"ok");
		r.setCod(ps.findAll());
		return ResponseEntity.ok().body(r);
	}
	
	@PostMapping
	public ResponseEntity<Return<Cartegory>> save(@PathParam("categoria") String categoria) throws NumberFormatException, IllegalAccessException {
		Return<Cartegory> r = new Return<>(true,"ok");
		r.getCod().add(ps.save(categoria));
		return ResponseEntity.ok().body(r);
	}
	
	@PutMapping
	public ResponseEntity<Return<Cartegory>> update(@PathParam("id") Long id,@PathParam("categoria") String categoria) throws NumberFormatException, IllegalAccessException {
		Return<Cartegory> r = new Return<>(true,"ok");
		r.getCod().add(ps.update(id, categoria));
		return ResponseEntity.ok().body(r);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Return<Cartegory>> delete(@PathVariable Long id) {
		ps.delete(id);
		Return<Cartegory> r = new Return<>(true,"apagado");
		return ResponseEntity.ok().body(r);
	}
	
}
