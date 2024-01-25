package com.example.Vaccination.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Vaccination.models.CentreVaccination;
import com.example.Vaccination.models.Citoyen;
import com.example.Vaccination.repository.CentreVaccinationRepository;
import com.example.Vaccination.repository.CitoyenRepository;

@Service
public class CentreVaccinationServiceImlp implements CentreVaccinationService{
    @Autowired
    private CentreVaccinationRepository centreVaccinationRepository;

    @Autowired
    private CitoyenRepository citoyenRepository;

    @Override
    public List <CentreVaccination> getAllCentreVaccinations() {
        return centreVaccinationRepository.findAll();
    }

    @Override
    public void saveCentreVaccination(CentreVaccination centreVaccination) {
        this.centreVaccinationRepository.save(centreVaccination);
    }

    @Override
    public CentreVaccination getCentreVaccinationById(long id) {
        Optional<CentreVaccination> optional = centreVaccinationRepository.findById(id);
        CentreVaccination CentreVaccination = null;
        if (optional.isPresent()) {
            CentreVaccination = optional.get();
        } else {
            throw new RuntimeException(" CentreVaccination not found for id :: " + id);
        }
        return CentreVaccination;
    }

    public List<Citoyen> getCitoyensByCentreVaccination(CentreVaccination centreVaccination) {
        return citoyenRepository.findByCentreVaccination(centreVaccination);
    }

    @Override
    public void deleteCentreVaccinationById(long id) {
        this.centreVaccinationRepository.deleteById(id);
    }
    
}
