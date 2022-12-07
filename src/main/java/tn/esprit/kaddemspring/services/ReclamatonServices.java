package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.Reclamation;

import java.util.List;

public interface ReclamatonServices {
    Reclamation addReclamation(Reclamation reclamation);

    List<Reclamation> findAllReclamations();

    void deleteReclamationById(Long id);

    Reclamation UpdateReclamation(Reclamation reclamation);
    Reclamation GetReclamationById(Long id);
}
