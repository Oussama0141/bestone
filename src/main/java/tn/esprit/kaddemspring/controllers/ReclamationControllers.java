package tn.esprit.kaddemspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Reclamation;
import tn.esprit.kaddemspring.services.ReclamatonServices;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Reclamation")

public class ReclamationControllers {

    @Autowired

    public ReclamatonServices ReclamationServices;
    @CrossOrigin("*")

    @GetMapping("/all")
    public ResponseEntity<List<Reclamation>> getAllreclamations(){
        List<Reclamation> Reclamations = ReclamationServices.findAllReclamations();
        return new ResponseEntity<>(Reclamations, HttpStatus.OK);
    }

    /******************************************************add reclamations***********************************************/
    /*here weexpecting the whole reclamation object which is going to be in json format that we're gonna expecting it coming
    from the user*/
    @PostMapping("/add")
    public ResponseEntity<Reclamation> addReclamationas(@RequestBody Reclamation Reclamation){
        Reclamation newreclamation = ReclamationServices.addReclamation(Reclamation);
        return new ResponseEntity<>(newreclamation, HttpStatus.CREATED);
    }
    /******************************************************update reclamation***********************************************/
    @PutMapping("/update")
    public ResponseEntity<Reclamation> updateReclamationss(@RequestBody Reclamation Reclamation){
        Reclamation Modifiedreclamation = ReclamationServices.UpdateReclamation(Reclamation);
        return new ResponseEntity<>(Modifiedreclamation, HttpStatus.OK);
    }
    @DeleteMapping("/deletereclamation/{id}")
    public void removereclamation(@PathVariable("id") Long id) {
        ReclamationServices.deleteReclamationById(id);
    }

    @GetMapping("/retrievereclamation/{id}")
    public Reclamation Retrievereclamation(@PathVariable("id") Long id) {
        return ReclamationServices.GetReclamationById(id);
    }

}

