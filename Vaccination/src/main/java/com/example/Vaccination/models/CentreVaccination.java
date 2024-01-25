package com.example.Vaccination.models;


import java.util.List;

import jakarta.persistence.*; 

@Entity
@Table(name = "CentreVaccination")
public class CentreVaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "centreVaccination")
    private List<Citoyen> citoyens;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public List<Citoyen> getCitoyens() {
        return this.citoyens;
    }

    public void setCitoyens(List<Citoyen> citoyens) {
        this.citoyens = citoyens;
    }



    
}
