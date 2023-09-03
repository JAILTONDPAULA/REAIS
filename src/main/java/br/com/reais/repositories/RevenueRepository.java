package br.com.reais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reais.entities.Revenue;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long>{

}
