package br.com.reais.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reais.entities.Cost;

@Repository
public interface CostRepository extends JpaRepository<Cost, Long>{
	List<Cost> findAllByOrderByDescription();
}
