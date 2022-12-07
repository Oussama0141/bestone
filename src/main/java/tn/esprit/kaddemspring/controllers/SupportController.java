package tn.esprit.kaddemspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Support;
import tn.esprit.kaddemspring.repository.SupportRepository;
import tn.esprit.kaddemspring.services.SupportService;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/support")
public class SupportController {


    @Autowired
    SupportService Services;
    @Autowired
    SupportRepository Sr;


    //ajout Support
    @PostMapping("/add")
    public Support AddSupport(@RequestBody Support Support){

        //   Support.setDevoir (false);
        Services.addSupport(Support);
        return Support;
    }


    //afficher lise Support
    @GetMapping("/all")
    public List<Support> findSupportList(){
        return (List<Support>) Sr.findAll();
    }



    //recherche un Support
    @GetMapping ("find/{id}")
    public Optional<Support> findSupportById(@PathVariable Long id){

        return Sr.findById(id);
    }


//update Support

    @PutMapping("update")
    public Support updateSupport(@RequestBody Support Support ){

        return Services.updateSupport(Support);
    }


//suppriemr avec id

    @DeleteMapping("delete/{id}")
    public void deleteSupport( @PathVariable("id") Long id) {
        Services.deleteSupport(id);
    }





}

