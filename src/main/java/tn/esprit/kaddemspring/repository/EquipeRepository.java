package tn.esprit.kaddemspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddemspring.model.DetailsEquipe;
import tn.esprit.kaddemspring.model.Equipe;
import tn.esprit.kaddemspring.model.Etudiant;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    @Query("SELECT e.detailsequipe.salle from Equipe e where e.idEquipe=:idEquipe")
    Integer findSalleByEquipe(@Param("idEquipe") Long idEquipe);
    @Query("SELECT e.detailsequipe.thematique from Equipe e where e.idEquipe=:idEquipe")
    String findThematiqueByEquipe(@Param("idEquipe") Long idEquipe);


}
