package com.example.Vaccination.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Vaccination.models.Citoyen;
import com.example.Vaccination.repository.CitoyenRepository;

@Service
public class CitoyenServiceImlp implements CitoyenService{
    @Autowired
    private CitoyenRepository citoyenRepository;

    @Override
    public List <Citoyen> getAllCitoyens() {
        return citoyenRepository.findAll();
    }

    @Override
    public void saveCitoyen(Citoyen citoyen) {
        this.citoyenRepository.save(citoyen);
    }

    @Override
    public Citoyen getCitoyenById(long id) {
        Optional<Citoyen> optional = citoyenRepository.findById(id);
        Citoyen Citoyen = null;
        if (optional.isPresent()) {
            Citoyen = optional.get();
        } else {
            throw new RuntimeException(" Citoyen not found for id :: " + id);
        }
        return Citoyen;
    }

    @Override
    public void deleteCitoyenById(long id) {
        this.citoyenRepository.deleteById(id);
    }
    
}
