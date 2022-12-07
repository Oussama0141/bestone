package tn.esprit.kaddemspring.controllers;

import org.apache.catalina.security.DeployXmlPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Departement;
import tn.esprit.kaddemspring.model.Etudiant;
import tn.esprit.kaddemspring.services.DepartementServices;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Departement")
public class DepartementControllers {
    @Autowired
    DepartementServices departreso  ;

    @GetMapping("/all")
    public List<Departement> displaydepart(){
        return departreso.retrieveAllDepartements();
    }
    @GetMapping("/displayalldepart/{id}")
    public Departement displaydepartbyid(@PathVariable("id") int id){
        return departreso.retrieveDepartement(id)	;
    }

    @PutMapping("/Updatedepart")
    @ResponseBody
    public Departement updateDepart(@RequestBody Departement de) {
        return departreso.updateDepartement(de);
    }

    @PostMapping("/adddepart")
    public ResponseEntity<Departement>AddDepart(@RequestBody  Departement de){
        return new ResponseEntity<Departement>(departreso.addDepartement(de),HttpStatus.CREATED);
    }

    @DeleteMapping("deletedepart/{idDepar}")
    public void removeDepartement(@PathVariable("idDepar") int idDepart){
        departreso.removeDepartement(idDepart);

    }

}
