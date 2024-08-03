package com.example.fitness.service;

import java.util.List;

import com.example.fitness.model.Expense;

public interface ExpenseService {
    List<Expense> findAll();
    void save(Expense expense);
    void delete(Long id);
     public Expense findById(Long id);
}
