package tn.esprit.kaddemspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.DetailsEquipe;
import tn.esprit.kaddemspring.model.Equipe;
import tn.esprit.kaddemspring.repository.DetailsEquipeRepository;
import tn.esprit.kaddemspring.repository.EquipeRepository;

import java.util.List;

@Service
public class DetailsEquipeServicesImpl implements DetailsEquipeServices {
@Autowired
 private DetailsEquipeRepository DetailsEquipeRepository;


    @Override
    public DetailsEquipe addDetailsE(DetailsEquipe detailsEquipe){
        return DetailsEquipeRepository.save(detailsEquipe);
    }

    @Override
    public List<DetailsEquipe> findAllDetailsEquipes(){
        return (List<DetailsEquipe>) DetailsEquipeRepository.findAll();
    }

    @Override
    public void deleteDetailsEquipeById(Long id) {
        DetailsEquipeRepository.deleteById(id);
    }

    @Override
    public DetailsEquipe UpdateDetailsEquipe(DetailsEquipe detailsEquipe){
        return DetailsEquipeRepository.save(detailsEquipe);
    }

    public DetailsEquipe GetDetailsEquipeById(Long id) {
        return DetailsEquipeRepository.findById(id).orElse(null);
    }


}
