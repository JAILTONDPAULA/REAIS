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

import br.com.reais.entities.People;
import br.com.reais.services.PeopleService;
import br.com.reais.settings.Return;
import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="pessoas")
public class PeopleResource {
	@Autowired
	private PeopleService ps;
	
	@GetMapping
	public ResponseEntity<Return<People>> findAll() {
		Return<People> r = new Return<>(true,"ok");
		r.setCod(ps.findAll());
		return ResponseEntity.ok().body(r);
	}
	
	@PostMapping
	public ResponseEntity<Return<People>> save(@PathParam("nome") String nome,@PathParam("parentesco") String parentesco) throws NumberFormatException, IllegalAccessException {
		Return<People> r = new Return<>(true,"ok");
		r.getCod().add(ps.save(nome,Integer.parseInt(parentesco)));
		return ResponseEntity.ok().body(r);
	}
	
	@PutMapping
	public ResponseEntity<Return<People>> update(@PathParam("id") Long id,@PathParam("nome") String nome,@PathParam("parentesco") String parentesco) throws NumberFormatException, IllegalAccessException {
		Return<People> r = new Return<>(true,"ok");
		r.getCod().add(ps.update(id, nome, Integer.parseInt(parentesco)));
		return ResponseEntity.ok().body(r);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Return<People>> delete(@PathVariable Long id) {
		ps.delete(id);
		Return<People> r = new Return<>(true,"apagado");
		return ResponseEntity.ok().body(r);
	}
	
}
