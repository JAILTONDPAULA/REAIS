package br.com.reais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reais.entities.OriginIncome;

@Repository
public interface OriginIncomeRepository extends JpaRepository<OriginIncome, Long>{
	OriginIncome findByDescription(String name);
}
