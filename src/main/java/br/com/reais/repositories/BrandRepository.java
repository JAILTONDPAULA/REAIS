package br.com.reais.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reais.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long>{
	List<Brand> findAllByOrderByDescription();
}
