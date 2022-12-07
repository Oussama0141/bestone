package tn.esprit.kaddemspring.controllers;

import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Etudiant;
import tn.esprit.kaddemspring.model.Utilisateur;
import tn.esprit.kaddemspring.services.UtilisateurServices;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Utilisateur")
public class UtilisateurControllers {

    @Autowired
    UtilisateurServices utilisateurServices;



    @GetMapping("/all")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs(){
        List<Utilisateur> utilisateurs = utilisateurServices.findAllUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    /******************************************************add students***********************************************/
    /*here weexpecting the whole student object which is going to be in json format that we're gonna expecting it coming
    from the userr*/
    @PostMapping("/add")
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur){

        Utilisateur newUtilisateur = utilisateurServices.addUtilisateur(utilisateur);
        return new ResponseEntity<>(newUtilisateur, HttpStatus.CREATED);
    }
    /******************************************************update student***********************************************/
    @PutMapping("/update")
    public ResponseEntity<Utilisateur> updateEtudiants(@RequestBody Utilisateur utilisateur){
        Utilisateur ModifiedUtilisateur = utilisateurServices.UpdateUtilisateur(utilisateur);
        return new ResponseEntity<>(ModifiedUtilisateur, HttpStatus.OK);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public void removeUtilisateur (@PathVariable("id") Long id) {
        utilisateurServices.deleteUtilisateurById(id);
    }

    @GetMapping("/retrieveStudent/{id}")
    public Utilisateur RetrieveUtilisateur(@PathVariable("id") Long id) {
        return utilisateurServices.GetUtilisateurById(id);
    }

}
