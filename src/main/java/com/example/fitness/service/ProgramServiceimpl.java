package com.example.fitness.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitness.model.Program;
import com.example.fitness.repository.ProgramRepository;

@Service
public class ProgramServiceimpl implements ProgramService {

    @Autowired
    private ProgramRepository programrepository;

    public List<Program> findAll() {
        List<Program>programs=programrepository.findAll();
        programs.forEach(program -> Hibernate.initialize(program.getName()));
        return programs;
    }

    public Program findById(Long id) {
        Program program = programrepository.findById(id).orElse(null);
        if (program != null) {
            Hibernate.initialize(program.getName());
        }
        return program;
    }


    public void save(Program program) {
        programrepository.save(program);
    }

    public void delete(Long id) {
        programrepository.deleteById(id);
      
    }



}
