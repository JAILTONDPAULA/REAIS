package br.com.reais.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reais.entities.Type;

public interface TypeRepository extends JpaRepository<Type, Long>{
	List<Type> findAllByOrderByDescription();
}
