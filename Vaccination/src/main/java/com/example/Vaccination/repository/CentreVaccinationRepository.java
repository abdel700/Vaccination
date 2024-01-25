package com.example.Vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Vaccination.models.CentreVaccination;

@Repository
public interface CentreVaccinationRepository extends JpaRepository<CentreVaccination, Long>{

}