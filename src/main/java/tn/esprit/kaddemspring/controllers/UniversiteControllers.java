package tn.esprit.kaddemspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Departement;
import tn.esprit.kaddemspring.model.Universite;
import tn.esprit.kaddemspring.services.UniversiteServices;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/universite")
public class UniversiteControllers {

    @Autowired
    UniversiteServices universervice  ;

    @GetMapping("/displayallUni")
    public List<Universite> displaydepart(){
        return universervice.retrieveAllUniversites();
    }
    @GetMapping("/displayalluniv/{id}")
    public Universite displaydepartbyid(@PathVariable("id") int id){
        return universervice.retrieveUniversite(id)	;
    }

    @PutMapping("/Updateuniver")
    @ResponseBody
    public Universite updateDepart(@RequestBody Universite de) {
        return universervice.updateUniversite(de);
    }

    @PostMapping("adduniv")
    public ResponseEntity<Universite>AddDepart(@RequestBody Universite de){
        return new ResponseEntity<Universite>(universervice.addUniversite(de),HttpStatus.CREATED);
    }

    @GetMapping("/universitetodepart/{iduniv}/{iddepart}")
    public void assignUniversiteToDepartement ( @PathVariable("iduniv") int idUniversite, @PathVariable("iddepart") int  idDepartement)
    {
        universervice.assignUniversiteToDepartement(idUniversite, idDepartement);
    }

    @GetMapping("/getdepart/{iduniv}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("iduniv") int idUniversite){
        return universervice.retrieveDepartementsByUniversite(idUniversite);
    }

    @DeleteMapping("deleteuniv/{iduniv}")
    public void removeUniversite(@PathVariable("iduniv") int idUniversite){
        universervice.removeUniversite(idUniversite);

    }


}

