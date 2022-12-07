package tn.esprit.kaddemspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddemspring.model.Formateur;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {



}
