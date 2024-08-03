package com.example.fitness.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitness.model.Area;
import com.example.fitness.model.Enquiry;
import com.example.fitness.repository.AreaRepository;
import com.example.fitness.repository.EnquiryRepository;

@Service
public class AreaServiceimpl implements AreaService{

    @Autowired
    private AreaRepository arearepository;

    public List<Area> findAll() {
       List<Area> areas = arearepository.findAll();
        areas.forEach(area -> Hibernate.initialize(area.getName()));
        return areas;
    }
    public Area findById(Long id) {
        Area area = arearepository.findById(id).orElse(null);
        if (area != null) {
            Hibernate.initialize(area.getName());
        }
        return area;
    }
    
    public void save(Area area) {
        arearepository.save(area);
    }

    
    public void delete(Long id) {
        arearepository.deleteById(id);
    }
    
}
