package tn.esprit.kaddemspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddemspring.model.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {
}


