package br.com.reais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reais.entities.Cartegory;
import br.com.reais.exceptions.NotFound;
import br.com.reais.repositories.CartegoryRepository;

@Service
public class CartegoryService {
	@Autowired
	private CartegoryRepository pr;
	
	public Cartegory findById(Long id) {
		Optional<Cartegory> p = pr.findById(id);
		return p.orElseThrow(()->new NotFound("ERROR:R005S<br><br>nenhuma cadastro encontrado"));
	}
	
	public List<Cartegory> findAll() {
		List<Cartegory> lp = pr.findAll();
		if(lp == null) {
			throw new NotFound("ERROR:R006S<br><br>nenhuma cadastro encontrado");
		}else {
			return lp;
		}
	}
	
	public Cartegory save(String descricao) throws IllegalAccessException {
		Cartegory p = new Cartegory(null,descricao);
		return pr.save(p);
	}
	
	public Cartegory update(Long id,String descricao) throws IllegalAccessException  {
		Cartegory p = this.findById(id);
		p.setDescription(descricao);
		return pr.save(p);
	}
	
	public void delete(Long id) {
		pr.deleteById(id);
	}
}
