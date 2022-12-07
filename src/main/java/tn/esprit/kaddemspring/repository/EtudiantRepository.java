package tn.esprit.kaddemspring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddemspring.model.Departement;
import tn.esprit.kaddemspring.model.Etudiant;
import tn.esprit.kaddemspring.model.Universite;

import java.util.List;
import java.util.Set;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {


    @Query(value = "Select * FROM  utilisateur e where e.departement_id_departement = ?1", nativeQuery = true)
    Set<Etudiant> getEtudiantsByDepartement(long idDepartement);

    @Query(value = "SELECT * from etudiants e " +
            "JOIN departement dep ON e.departement_id_departement = dep.id_departement " +
            "JOIN université_departement_set unidep ON dep.id_departement = unidep.departement_set_id_departement " +
            "Join Université uni ON uni.id_universite = unidep.université_id_universite " +
            "WHERE dep.id_departement =: #{#departement.idDepartement} " +
            "and uni.id_universite =: #{#universite.idUniversite}", nativeQuery = true)
    List<Etudiant> getEtudiantByDeppAndUni(@Param("departement") Departement Departement, @Param("universite") Universite Universite);


}