package br.com.reais.resources;

import java.time.LocalDate;
import java.util.List;

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

import br.com.reais.entities.Revenue;
import br.com.reais.services.RevenueService;
import br.com.reais.settings.Return;
import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="receitas")
public class RevenueResource {
	@Autowired
	private RevenueService rs;
	
	@GetMapping
	public ResponseEntity<Return<Revenue>> findAll(){
		List<Revenue>   lr  = rs.findAll();
		Return<Revenue> ret = new Return<Revenue>(true,"OK");
		ret.setCod(lr);
		return ResponseEntity.ok().body(ret);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Return<Revenue>> findById(@PathVariable Long id) {
		Revenue receita = rs.findById(id);
		Return<Revenue>  ret = new Return<Revenue>(true,"OK");
		ret.getCod().add(receita);
		return ResponseEntity.ok().body(ret);
	}
	
	@PostMapping
	public ResponseEntity<Return<Revenue>> save(@PathParam("origem")     String origem,
											    @PathParam("valor")      String valor ,
											    @PathParam("data")       String data  ,
											    @PathParam("ano")        String ano   ,
											    @PathParam("mes")        String mes   ,
											    @PathParam("mensal")     String mensal,
											    @PathParam("observacao") String observacao){
		
		Double    valor2 = Double.parseDouble(valor.replaceAll("\\.","").replaceAll(",","."));
		LocalDate data2  = LocalDate.parse(data);
		int       ano2   = Integer.valueOf(ano).intValue();
		int       mes2   = Integer.valueOf(mes).intValue();
		
		Revenue rv = rs.save(origem,valor2,data2,ano2,mes2,mensal,observacao);
		Return<Revenue> ret = new Return<>(true,"OK");
		ret.getCod().add(rv);
		return ResponseEntity.status(201).body(ret);
	}
	
	@PutMapping
	public ResponseEntity<Return<Revenue>> update(@PathParam("id")         String id    ,
												  @PathParam("origem")     String origem,
											      @PathParam("valor")      String valor ,
											      @PathParam("data")       String data  ,
											      @PathParam("ano")        String ano   ,
											      @PathParam("mes")        String mes   ,
											      @PathParam("mensal")     String mensal,
											      @PathParam("observacao") String observacao){
		
		Double    valor2 = Double.parseDouble(valor.replaceAll("\\.","").replaceAll(",","."));
		LocalDate data2  = LocalDate.parse(data);
		int       ano2   = Integer.valueOf(ano).intValue();
		int       mes2   = Integer.valueOf(mes).intValue();
		
		Revenue rv = rs.update(id,origem,valor2,data2,ano2,mes2,mensal,observacao);
		Return<Revenue> ret = new Return<>(true,"OK");
		ret.getCod().add(rv);
		return ResponseEntity.status(201).body(ret);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Return<String>> delete(@PathVariable Long id) {
		rs.delete(id);
		Return<String> ret = new Return<>(true,"APAGADO");
		return ResponseEntity.ok().body(ret);
	}

	
}
