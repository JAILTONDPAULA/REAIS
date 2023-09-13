package br.com.reais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reais.entities.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long>{

}
