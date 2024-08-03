package com.example.fitness.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitness.model.Enquiry;
import com.example.fitness.repository.EnquiryRepository;

@Service
public class EnquiryServiceimpl implements EnquiryService {

    @Autowired
    private EnquiryRepository enquiryrepository;

    public List<Enquiry> findAll() {
       List<Enquiry> enquiries = enquiryrepository.findAll();
        enquiries.forEach(enquiry -> Hibernate.initialize(enquiry.getArea()));
        enquiries.forEach(enquiry -> Hibernate.initialize(enquiry.getProgram()));
        return enquiries;
    }

    public Enquiry findById(Long id) {
        Enquiry enquiry = enquiryrepository.findById(id).orElse(null);
        if (enquiry != null) {
            Hibernate.initialize(enquiry.getProgram());
            Hibernate.initialize(enquiry.getArea());
        }
        return enquiry;
    }


    public void save(Enquiry enquiry) {
    if (enquiry.getFirstNameOfPar() == null) {
        enquiry.setFirstNameOfPar("");
    }
    if (enquiry.getLastNameOfPar() == null) {
        enquiry.setLastNameOfPar("");
    }
    enquiryrepository.save(enquiry);
}

    public void delete(long id) {
        enquiryrepository.deleteById(id);
      
    }
    
}
