package com.example.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fitness.model.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program,Long>{
    
}

