package com.example.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fitness.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
 
}
