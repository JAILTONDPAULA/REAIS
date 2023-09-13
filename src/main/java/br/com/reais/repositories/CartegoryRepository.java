package br.com.reais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reais.entities.Cartegory;

@Repository
public interface CartegoryRepository extends JpaRepository<Cartegory, Long>{

}
