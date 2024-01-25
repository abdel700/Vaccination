package com.example.Vaccination.services;
import java.util.List;

import com.example.Vaccination.models.CentreVaccination;
import com.example.Vaccination.models.Citoyen;
public interface CentreVaccinationService {
    List < CentreVaccination > getAllCentreVaccinations();
    void saveCentreVaccination(CentreVaccination CentreVaccination);
    CentreVaccination getCentreVaccinationById(long id);
    void deleteCentreVaccinationById(long id);
    List<Citoyen> getCitoyensByCentreVaccination(CentreVaccination centreVaccination);
}
