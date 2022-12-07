package tn.esprit.kaddemspring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Contrat;
import tn.esprit.kaddemspring.services.ContratServices;

import java.util.List;

    @CrossOrigin(origins = "*")
    @RestController
    @RequestMapping("/Contrat")
    public class ContratControllers {
        @Autowired

        public ContratServices ContratServices;

        @GetMapping("/all")
        public ResponseEntity<List<Contrat>> getAllcontracts(){
            List<Contrat> Contrats = ContratServices.findAllContrats();
            return new ResponseEntity<>(Contrats, HttpStatus.OK);
        }

        /******************************************************add contracts***********************************************/
    /*here weexpecting the whole contract object which is going to be in json format that we're gonna expecting it coming
    from the user*/
        @PostMapping("/add")
        public ResponseEntity<Contrat> addContratas(@RequestBody Contrat Contrat){
            Contrat newcontract = ContratServices.addContrat(Contrat);
            return new ResponseEntity<>(newcontract, HttpStatus.CREATED);
        }
        /******************************************************update contract***********************************************/
        @PutMapping("/update")
        public ResponseEntity<Contrat> updateContratss(@RequestBody Contrat Contrat){
            Contrat Modifiedcontract = ContratServices.UpdateContrat(Contrat);
            return new ResponseEntity<>(Modifiedcontract, HttpStatus.OK);
        }
        @DeleteMapping("/deletecontract/{id}")
        public void removecontract(@PathVariable("id") Long id) {
            ContratServices.deleteContratById(id);
        }

        @GetMapping("/retrievecontract/{id}")
        public Contrat Retrievecontract(@PathVariable("id") Long id) {
            return ContratServices.GetContratById(id);
        }



}
