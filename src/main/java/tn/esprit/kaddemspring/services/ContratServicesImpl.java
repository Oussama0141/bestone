package tn.esprit.kaddemspring.services;

import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.Contrat;
import tn.esprit.kaddemspring.model.Equipe;
import tn.esprit.kaddemspring.repository.ContratRepository;

import java.util.List;

@Service
public class ContratServicesImpl implements ContratServices {
    private ContratRepository ContratRepository;

    public ContratServicesImpl(ContratRepository contratRepository) {
        ContratRepository = contratRepository;
    }

    @Override
    public Contrat addContrat(Contrat contrat){
        return ContratRepository.save(contrat);
    }

    @Override
    public List<Contrat> findAllContrats(){
        return (List<Contrat>) ContratRepository.findAll();
    }

    @Override
    public void deleteContratById(Long id) {
        ContratRepository.deleteById(id);
    }

    @Override
    public Contrat UpdateContrat(Contrat contrat){
        return ContratRepository.save(contrat);
    }

    public Contrat GetContratById(Long id) {
        return ContratRepository.findById(id).orElse(null);
    }


}
