package com.example.Vaccination.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Vaccination.models.Citoyen;
import com.example.Vaccination.services.CentreVaccinationService;
import com.example.Vaccination.services.CitoyenService;


@Controller
public class CitoyenController {

    @Autowired
    private CitoyenService citoyenService;

    @Autowired
    private CentreVaccinationService centreVaccinationService;

    // display list of citoyens
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listCitoyens", citoyenService.getAllCitoyens());
        return "index";
    }

    @GetMapping("/showNewCitoyenForm")
    public String showNewCitoyenForm(Model model) {
        // create model attribute to bind form data
        Citoyen citoyen = new Citoyen();
        model.addAttribute("centresVaccination", centreVaccinationService.getAllCentreVaccinations());
        model.addAttribute("citoyen", citoyen);
        return "new_citoyen";
    }

    @PostMapping("/saveCitoyen")
    public String saveCitoyen(@ModelAttribute("citoyen") Citoyen citoyen) {
        // save citoyen to database
        citoyenService.saveCitoyen(citoyen);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get citoyen from the service
        Citoyen citoyen = citoyenService.getCitoyenById(id);

        // set citoyen as a model attribute to pre-populate the form
        model.addAttribute("citoyen", citoyen);
        return "update_citoyen";
    }

    @GetMapping("/deleteCitoyen/{id}")
    public String deleteCitoyen(@PathVariable(value = "id") long id) {

        // call delete citoyen method 
        this.citoyenService.deleteCitoyenById(id);
        return "redirect:/";
    }


}