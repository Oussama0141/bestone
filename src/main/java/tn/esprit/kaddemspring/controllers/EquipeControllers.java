package tn.esprit.kaddemspring.controllers;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Contrat;
import tn.esprit.kaddemspring.model.DetailsEquipe;
import tn.esprit.kaddemspring.model.Equipe;
import tn.esprit.kaddemspring.repository.DetailsEquipeRepository;
import tn.esprit.kaddemspring.repository.EquipeRepository;
import tn.esprit.kaddemspring.services.DetailsEquipeServices;
import tn.esprit.kaddemspring.services.EquipeServices;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Equipe")
public class EquipeControllers {
    @Autowired
    private EquipeServices EquipeServices;
    @Autowired
    public DetailsEquipeServices DetailsEquipeServices;
    @Autowired
    private DetailsEquipeRepository DERep ;
    @Autowired
    private EquipeRepository EquRep ;


    @GetMapping("/TestApi")
    public String Test(){
        return  "Api work ";
    }


    // http://localhost:8090/kaddem/Equipe/GetAllEquipe
    @GetMapping("/GetAllEquipe")
    public ResponseEntity<List<Equipe>> getAllEquipes(){
        List<Equipe> Equipes = EquipeServices.findAllEquipes();


        return new ResponseEntity<List<Equipe>>(Equipes, HttpStatus.OK);
    }

    /******************************************************add contracts***********************************************/
    /*here weexpecting the whole contract object which is going to be in json format that we're gonna expecting it coming
    from the user*/
    // http://localhost:8090/kaddem/Equipe/AddEquipe
    @PostMapping("/AddEquipe")
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe){
        Equipe newEquipe = EquipeServices.addEquipe(equipe) ;
        return new ResponseEntity<Equipe>(newEquipe, HttpStatus.CREATED);
    }
    /******************************************************update contract***********************************************/
    // http://localhost:8090/kaddem/Equipe/UpdateEquipe
    @PutMapping("/UpdateEquipe")
    public ResponseEntity<Equipe> updateEquipe(@RequestBody Equipe equipe){
        Equipe ModifiedEquipe = EquipeServices.UpdateEquipe(equipe) ;

        return new ResponseEntity<Equipe>(ModifiedEquipe, HttpStatus.OK);
    }
    // http://localhost:8090/kaddem/Equipe/DeleteEquipe/id
    @DeleteMapping("/DeleteEquipe/{id}")
    public String  removeEquipe(@PathVariable("id") Long id) {

        EquipeServices.deleteEquipeById(id) ;

        return "Message deleted !";
    }
    // http://localhost:8090/kaddem/Equipe/RetrieveEquipe/{id}
    @GetMapping("/RetrieveEquipe/{id}")
    public ResponseEntity<Equipe> RetrieveEquipe(@PathVariable("id") Long id) {

        return new ResponseEntity<Equipe>(EquipeServices.GetEquipeById(id), HttpStatus.OK);
    }
    // http://localhost:8090/kaddem/Equipe/retrieve-salle-byid/{id}
    @GetMapping("/retrieve-salle-byid/{id}")
    public Integer getDetailEquipes(@PathVariable("id") Long IdEquipe) {
        Integer d = EquRep.findSalleByEquipe(IdEquipe);
        return d;
    }

    // http://localhost:8090/kaddem/Equipe/retrieve-salle-byid/{id}
    @GetMapping("/retrieve-thematique-byid/{id}")
    public String getthematiqueEquipes(@PathVariable("id") Long IdEquipe) {
        String d = EquRep.findThematiqueByEquipe(IdEquipe);
        return d;
    }
    // http://localhost:8090/kaddem/Equipe/change_niveau
    @PutMapping("/change_niveau")
    public String changeniveau() {
        EquipeServices.faireEvoluerEquipes();
        return "success";
    }



}
