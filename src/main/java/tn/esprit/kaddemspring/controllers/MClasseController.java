package tn.esprit.kaddemspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.MClasse;
import tn.esprit.kaddemspring.model.Support;
import tn.esprit.kaddemspring.repository.MClasseRepository;
import tn.esprit.kaddemspring.services.MClasseService;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/MClasse")
public class MClasseController {


    @Autowired
    MClasseService Services;
    @Autowired
    MClasseRepository MCr;


    //ajout MClasse
    @PostMapping("/add")
    public MClasse AddMClasse(@RequestBody MClasse MClasse){

        Services.addMClasse(MClasse);
        return MClasse;
    }


    //afficher lise MClasse
    @GetMapping("/all")
    public List<MClasse> findMClasseList(){
        return (List<MClasse>) MCr.findAll();
    }



    //recherche un MClasse
    @GetMapping ("find/{id}")
    public Optional<MClasse> findMClasseById(@PathVariable Long id){

        return MCr.findById(id);
    }






//update mclasse

    @PutMapping("/update")
    public MClasse updateMClasse(@RequestBody MClasse MClasse ){

        return Services.updateMClasse(MClasse);
    }


//suppriemr avec id

    @DeleteMapping("delete/{id}")
    public void deleteMClasse( @PathVariable("id") Long id) {
        Services.deleteMClasse(id);
    }




    @GetMapping("get/{id}")
    List<Support> getSupportsByMClasse(@PathVariable("id") Integer id){
        return Services.getSupportsByMClasse(id);
    }


}
