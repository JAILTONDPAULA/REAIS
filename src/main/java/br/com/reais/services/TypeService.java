package br.com.reais.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reais.entities.Type;
import br.com.reais.repositories.TypeRepository;

@Service
public class TypeService {
	@Autowired
	private TypeRepository tr;
	
	public List<Type> findAll() {
		return tr.findAllByOrderByDescription();
	}
	
	public List<String> list() {
		List<Type>   lt = this.findAll();
		List<String> ls = new ArrayList<>();
		for (Type type : lt) {
			ls.add(type.getDescription());
		}
		return ls;
	}
}
