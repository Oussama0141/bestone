package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.DetailsEquipe;
import tn.esprit.kaddemspring.model.Equipe;

import java.util.List;

public interface DetailsEquipeServices {
    DetailsEquipe addDetailsE(DetailsEquipe detailsEquipe);

    List<DetailsEquipe> findAllDetailsEquipes();

    void deleteDetailsEquipeById(Long id);

    DetailsEquipe UpdateDetailsEquipe(DetailsEquipe detailsEquipe);
    DetailsEquipe GetDetailsEquipeById(Long id) ;

}
