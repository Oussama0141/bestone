package tn.esprit.kaddemspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.DetailsEquipe;
import tn.esprit.kaddemspring.model.Equipe;
import tn.esprit.kaddemspring.repository.EquipeRepository;
import tn.esprit.kaddemspring.services.DetailsEquipeServices;
import tn.esprit.kaddemspring.services.EquipeServices;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/DetailsEquipe")
public class DetailsEquipeControllers {
    @Autowired
    public DetailsEquipeServices DetailsEquipeServices;
    @Autowired
    public EquipeServices EquipeServices ;
    @Autowired
    public EquipeRepository EquipeRepo ;

    // http://localhost:8090/kaddem/DetailsEquipe/GetDetailsByIdEquipe/{idEquipe}

    @GetMapping("/GetDetailsByIdEquipe/{idEquipe}")
    public ResponseEntity<DetailsEquipe> DetaileEquipe(@PathVariable("idEquipe")Long IdEquipe ){

        Equipe newEquipe = EquipeServices.GetEquipeById(IdEquipe);
        DetailsEquipe detailsEquipe = DetailsEquipeServices.GetDetailsEquipeById(newEquipe.getIdEquipe());
        return new ResponseEntity<DetailsEquipe>(detailsEquipe, HttpStatus.OK);
    }


    // http://localhost:8090/kaddem/DetailsEquipe/UpDetailsEquipe
    @PutMapping("/UpDetailsEquipe")
    public ResponseEntity<DetailsEquipe> UpDetaileEquipe(@RequestBody DetailsEquipe detailsEquipe ){
        return new ResponseEntity<DetailsEquipe>(DetailsEquipeServices.UpdateDetailsEquipe(detailsEquipe), HttpStatus.OK);
    }
    // http://localhost:8090/kaddem/DetailsEquipe/DeleteDetail/{id}
    @DeleteMapping("/DeleteDetail/{id}")
    public String removeDetailEquipe(@PathVariable("id") Long id) {

        DetailsEquipeServices.deleteDetailsEquipeById(id);
        return "Detail deleted !";
    }
}
