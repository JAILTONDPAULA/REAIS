package br.com.reais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reais.entities.People;
import br.com.reais.enums.Kinship;
import br.com.reais.exceptions.NotFound;
import br.com.reais.repositories.PeopleRepository;

@Service
public class PeopleService {
	@Autowired
	private PeopleRepository pr;
	
	public People findById(Long id) {
		Optional<People> p = pr.findById(id);
		return p.orElseThrow(()->new NotFound("ERROR:R002S<br><br>nenhuma cadastro encontrado"));
	}
	
	public List<People> findAll() {
		List<People> lp = pr.findAll();
		if(lp == null) {
			throw new NotFound("ERROR:R001S<br><br>nenhuma cadastro encontrado");
		}else {
			return lp;
		}
	}
	
	public People save(String nome,Integer parentesco) throws IllegalAccessException {
		if(parentesco == 9) {
			throw new IllegalArgumentException("ERROR:R003S<br><br>permitido cadastro de apenas um titular");
		}
		People p = new People(null,nome,Kinship.toEnum(parentesco));
		return pr.save(p);
	}
	
	public People update(Long id,String nome,Integer parentesco) throws IllegalAccessException  {
		if(parentesco == 9) {
			throw new IllegalArgumentException("ERROR:R004S<br><br>permitido cadastro de apenas um titular");
		}
		People p = this.findById(id);
		p.setName(nome);
		p.setKinship(Kinship.toEnum(parentesco));
		return pr.save(p);
	}
	
	public void delete(Long id) {
		pr.deleteById(id);
	}
}
