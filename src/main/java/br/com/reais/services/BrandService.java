package br.com.reais.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reais.entities.Brand;
import br.com.reais.repositories.BrandRepository;

@Service
public class BrandService {
	@Autowired
	private BrandRepository tr;
	
	public List<Brand> findAll() {
		return tr.findAllByOrderByDescription();
	}
	
	public List<String> list() {
		List<Brand>   lt = this.findAll();
		List<String> ls = new ArrayList<>();
		for (Brand Brand : lt) {
			ls.add(Brand.getDescription());
		}
		return ls;
	}
}
