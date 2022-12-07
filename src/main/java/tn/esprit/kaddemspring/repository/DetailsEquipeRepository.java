package tn.esprit.kaddemspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddemspring.model.DetailsEquipe;
import tn.esprit.kaddemspring.model.Etudiant;

@Repository
public interface DetailsEquipeRepository extends JpaRepository<DetailsEquipe, Long> {
}
