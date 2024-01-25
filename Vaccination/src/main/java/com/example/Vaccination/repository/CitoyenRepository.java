package com.example.Vaccination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Vaccination.models.CentreVaccination;
import com.example.Vaccination.models.Citoyen;

@Repository
public interface CitoyenRepository extends JpaRepository<Citoyen, Long>{
    List<Citoyen> findByCentreVaccination(CentreVaccination centreVaccination);

}