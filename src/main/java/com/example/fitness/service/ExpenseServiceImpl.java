package com.example.fitness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitness.model.Expense;
import com.example.fitness.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

   
    @Override
    public List<Expense> findAll() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses;
    }

     public Expense findById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Expense expense) {
        expenseRepository.save(expense);
    }

    @Override
    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }
}
