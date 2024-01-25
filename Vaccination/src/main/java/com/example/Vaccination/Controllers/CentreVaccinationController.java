package com.example.Vaccination.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Vaccination.models.CentreVaccination;
import com.example.Vaccination.models.Citoyen;
import com.example.Vaccination.services.CentreVaccinationService;


@Controller
public class CentreVaccinationController {

    @Autowired
    private CentreVaccinationService centreVaccinationService;

    // display list of centreVaccinations
    @GetMapping("/CentreVaccination")
    public String viewHomePage(Model model) {
        model.addAttribute("listCentreVaccinations", centreVaccinationService.getAllCentreVaccinations());
        return "Centre_Vaccination";
    }

    @GetMapping("/showNewCentreVaccinationForm")
    public String showNewCentreVaccinationForm(Model model) {
        // create model attribute to bind form data
        CentreVaccination centreVaccination = new CentreVaccination();
        model.addAttribute("centreVaccination", centreVaccination);
        return "new_centreVaccination";
    }

    @PostMapping("/saveCentreVaccination")
    public String saveCentreVaccination(@ModelAttribute("centreVaccination") CentreVaccination centreVaccination) {
        // save centreVaccination to database
        centreVaccinationService.saveCentreVaccination(centreVaccination);
        return "redirect:/CentreVaccination";
    }

    @GetMapping("/showFormForUpdateCentre/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get centreVaccination from the service
        CentreVaccination centreVaccination = centreVaccinationService.getCentreVaccinationById(id);

        // set centreVaccination as a model attribute to pre-populate the form
        model.addAttribute("centreVaccination", centreVaccination);
        return "update_centreVaccination";
    }

    @GetMapping("/deleteCentreVaccination/{id}")
    public String deleteCentreVaccination(@PathVariable(value = "id") long id) {

        // call delete centreVaccination method 
        this.centreVaccinationService.deleteCentreVaccinationById(id);
        return "redirect:/CentreVaccination";
    }


    @GetMapping("/afficher/{id}")
    public String afficherCentreVaccination(@PathVariable(value = "id") Long id, Model model) {
        CentreVaccination centreVaccination = centreVaccinationService.getCentreVaccinationById(id);

        List<Citoyen> citoyens = centreVaccinationService.getCitoyensByCentreVaccination(centreVaccination);

        model.addAttribute("centreVaccination", centreVaccination);
        model.addAttribute("citoyens", citoyens);

        return "afficherCentreVaccination";
    }
}