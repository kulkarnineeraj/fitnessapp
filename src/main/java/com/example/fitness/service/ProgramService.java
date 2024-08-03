package com.example.fitness.service;

import java.util.List;

import com.example.fitness.model.Program;

public interface ProgramService{

    public List<Program> findAll() ;

    public Program findById(Long id) ;


    public void save(Program program) ;

    public void delete(Long id) ;
}
