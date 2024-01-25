package com.example.Vaccination.models;



import jakarta.persistence.*; 

@Entity
@Table(name = "citoyen")
public class Citoyen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;


    @ManyToOne
    @JoinColumn(name = "centre_vaccination_id")
    private CentreVaccination centreVaccination;


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


    public CentreVaccination getCentreVaccination() {
        return this.centreVaccination;
    }

    public void setCentreVaccination(CentreVaccination centreVaccination) {
        this.centreVaccination = centreVaccination;
    }





    
}
