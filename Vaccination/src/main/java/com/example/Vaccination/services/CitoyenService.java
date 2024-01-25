package com.example.Vaccination.services;
import java.util.List;

import com.example.Vaccination.models.Citoyen;
public interface CitoyenService {
    List < Citoyen > getAllCitoyens();
    void saveCitoyen(Citoyen Citoyen);
    Citoyen getCitoyenById(long id);
    void deleteCitoyenById(long id);
    
}
