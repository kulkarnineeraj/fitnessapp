package com.example.fitness.service;

import java.util.List;

import com.example.fitness.model.Enquiry;

public interface EnquiryService {
    public List<Enquiry> findAll() ;

    public Enquiry findById(Long id) ;


    public void save(Enquiry enquiry);
    
    public void delete(long id) ;
    
    
}
