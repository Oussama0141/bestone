package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.Contrat;

import java.util.List;

public interface ContratServices {
    Contrat addContrat(Contrat contrat);

    List<Contrat> findAllContrats();

    void deleteContratById(Long id);

    Contrat UpdateContrat(Contrat contrat);
    Contrat GetContratById(Long id);
}
