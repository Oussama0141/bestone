package tn.esprit.kaddemspring.services;

import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.Reclamation;
import tn.esprit.kaddemspring.repository.ReclamationRepository;

import java.util.List;
@Service
public class ReclamationServicesImpl implements ReclamatonServices {
    private ReclamationRepository ReclamationRepository;

    public ReclamationServicesImpl(ReclamationRepository reclamationRepository) {
        ReclamationRepository = reclamationRepository;
    }

    @Override
    public Reclamation addReclamation(Reclamation reclamation){
        return ReclamationRepository.save(reclamation);
    }

    @Override
    public List<Reclamation> findAllReclamations(){
        return (List<Reclamation>) ReclamationRepository.findAll();
    }

    @Override
    public void deleteReclamationById(Long id) {
        ReclamationRepository.deleteById(id);
    }

    @Override
    public Reclamation UpdateReclamation(Reclamation reclamation){
        return ReclamationRepository.save(reclamation);
    }

    public Reclamation GetReclamationById(Long id) {
        return ReclamationRepository.findById(id).orElse(null);
    }


}


