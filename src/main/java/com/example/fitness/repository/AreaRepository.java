package com.example.fitness.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitness.model.Area;
import com.example.fitness.model.Enquiry;

public interface AreaRepository extends JpaRepository<Area,Long>  {

    public List<Area> findAll();
}
