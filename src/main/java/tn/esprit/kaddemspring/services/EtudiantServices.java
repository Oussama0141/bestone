package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.*;

import java.util.List;
import java.util.Set;

public interface EtudiantServices {
    Etudiant addEtudiant(Etudiant etudiant);

    List<Etudiant> findAllEtudiants();

    void deleteEtudiantById(Long id);

    Etudiant UpdateEtudiant(Etudiant etudiant);

    Etudiant GetEtudiantById(Long id);

    Set<Etudiant> getEtudiantsByDepartement(long idDepartement);

    void assignEtudiantToDepartement(Integer etudiantId, Integer departementId);

    void desaffectEtudiantToDepartement(Integer etudiantId, Integer departementId);

    Set<Etudiant> getEtudiantByDepAndUni(Departement Departement, Universite Universite);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);

    public Set<Contrat> getEtudiantContrats (Long idUser);

    public Set<Equipe> getEtudiantEquipes (Long idUser);

    public Etudiant AssignContratEtudiant (long idUser,long idContrat);


    public Etudiant AssignEquipeEtudiant(long idUser,long idEquipe);

    }

