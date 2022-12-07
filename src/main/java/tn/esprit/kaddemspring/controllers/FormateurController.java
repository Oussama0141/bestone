package tn.esprit.kaddemspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Formateur;
import tn.esprit.kaddemspring.repository.FormateurRepository;
import tn.esprit.kaddemspring.services.FormateurService;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Formateur")
public class FormateurController {
    @Autowired
    FormateurService Services;
    @Autowired
    FormateurRepository Fr;


    //ajout formateur
    @PostMapping("/add")
    public Formateur AddFormateur(@RequestBody Formateur Formateur){

        Services.addFormateur(Formateur);
        return Formateur;
    }


    //afficher lise formateur
    @GetMapping("/all")
    public List<Formateur> findFormateurList(){
        return (List<Formateur>) Fr.findAll();
    }



    //recherche un Formateur
    @GetMapping ("find/{id}")
    public Optional<Formateur> findFormateurById(@PathVariable Long id){

        return Fr.findById(id);
    }


//update Formateur

    @PutMapping("/update")
    public Formateur updateFormateur(@RequestBody Formateur Formateur ){

        return Services.updateFormateur(Formateur);
    }


//suppriemr avec id

    @DeleteMapping("delete/{id}")
    public void deleteFormateur( @PathVariable("id") Long id) {
        Services.deleteFormateur(id);
    }


}
