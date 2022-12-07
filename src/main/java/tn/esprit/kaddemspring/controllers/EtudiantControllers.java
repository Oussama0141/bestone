package tn.esprit.kaddemspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Contrat;
import tn.esprit.kaddemspring.model.Equipe;
import tn.esprit.kaddemspring.model.Etudiant;
import tn.esprit.kaddemspring.services.EtudiantServices;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/etudiant")
public class EtudiantControllers {

    @Autowired
    public EtudiantServices EtudiantServices;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<Etudiant>> getAllStudents(){
        List<Etudiant> etudiants = EtudiantServices.findAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping("/contrat/{id}")
    public ResponseEntity<Set<Contrat>> getEtudiantContrats(@PathVariable("id") long id){
        Set<Contrat> Contrats = EtudiantServices.getEtudiantContrats(id);
        return new ResponseEntity<>(Contrats, HttpStatus.OK);
    }

    @GetMapping("/equipe")
    public ResponseEntity<Set<Equipe>> getEtudiantEquipes(@RequestParam(name="id") long id){
        Set<Equipe> Equipes = EtudiantServices.getEtudiantEquipes(id);
        return new ResponseEntity<>(Equipes, HttpStatus.OK);
    }

    @GetMapping("/departement")
    public ResponseEntity<Set<Etudiant>> getEtudiantsByDepartement(@RequestParam(name="id") long id){
        Set<Etudiant> Etudiants = EtudiantServices.getEtudiantsByDepartement(id);
        return new ResponseEntity<>(Etudiants, HttpStatus.OK);
    }

    /******************************************************add students***********************************************/
    /*here weexpecting the whole student object which is going to be in json format that we're gonna expecting it coming
    from the userr*/
    @PostMapping("/add")
    public ResponseEntity<Etudiant> addEtudiants(@RequestBody Etudiant etudiant){

        Etudiant newStudent = EtudiantServices.addEtudiant(etudiant);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @PostMapping("/assignContrat")
    public Etudiant AssignContratEtudiant(@RequestParam(name="id") long id,@RequestParam(name="idContrat") long idContrat ){
       return EtudiantServices.AssignContratEtudiant(id,idContrat);
    }


    @PostMapping("/assignEquipe")
    public Etudiant AssignEquipeEtudiant(@RequestParam(name="id") long id,@RequestParam(name="idEquipe") long idEquipe ){
        return EtudiantServices.AssignEquipeEtudiant(id,idEquipe);
    }
    /******************************************************update student***********************************************/
    @PutMapping("/update")
    public ResponseEntity<Etudiant> updateEtudiants(@RequestBody Etudiant etudiant){
        Etudiant ModifiedStudent = EtudiantServices.UpdateEtudiant(etudiant);
        return new ResponseEntity<>(ModifiedStudent, HttpStatus.OK);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public void removeStudent(@PathVariable("id") Long id) {
        EtudiantServices.deleteEtudiantById(id);
    }

    @GetMapping("/retrieveStudent/{id}")
    public Etudiant RetrieveStudent(@PathVariable("id") Long id) {
        return EtudiantServices.GetEtudiantById(id);
    }

}
