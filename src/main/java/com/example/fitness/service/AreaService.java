package com.example.fitness.service;

import java.util.List;

import com.example.fitness.model.Area;

public interface AreaService{
     public List<Area> findAll() ;

    public Area findById(Long id);
    
    public void save(Area area);

    
    public void delete(Long id) ;

   


}