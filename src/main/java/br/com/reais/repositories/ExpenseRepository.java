package br.com.reais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reais.entities.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
