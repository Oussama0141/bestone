package tn.esprit.kaddemspring.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.*;
import tn.esprit.kaddemspring.repository.ContratRepository;
import tn.esprit.kaddemspring.repository.DepartementRepository;
import tn.esprit.kaddemspring.repository.EquipeRepository;
import tn.esprit.kaddemspring.repository.EtudiantRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class EtudiantServicesImpl implements EtudiantServices {

    @Autowired
    EtudiantRepository EtudiantRepository;
    @Autowired
    ContratRepository ContratRepository;
    @Autowired
    EquipeRepository EquipeRepository;
    @Autowired
    DepartementRepository DepartementRepository;


    @Override
    public Etudiant addEtudiant(Etudiant etudiant){
        long depid;
        String depnom;
        Departement dep;
        depid=etudiant.getDepartement().getIdDepartement();
        dep = DepartementRepository.findById(depid).orElse(null);
        depnom= dep.getNomDepartement();
        etudiant.getDepartement().setNomDepartement(depnom);
        Role role = new Role();
        role.setTypeRole(TypeRole.Etudiant);
        etudiant.setRole(role);
        return EtudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> findAllEtudiants(){
        return EtudiantRepository.findAll();
    }

    @Override
    public void deleteEtudiantById(Long id) {
        EtudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant UpdateEtudiant(Etudiant etudiant){
        return EtudiantRepository.save(etudiant);
    }

    public Etudiant GetEtudiantById(Long id) {
        return EtudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Etudiant> getEtudiantsByDepartement(long idDepartement) {
        return EtudiantRepository.getEtudiantsByDepartement(idDepartement);
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
    Etudiant e = EtudiantRepository.findById(Long.valueOf(etudiantId)).get();
    Departement d = DepartementRepository.findById(Long.valueOf(departementId)).get();
    e.setDepartement(d);
    EtudiantRepository.save(e);
    }

    public void desaffectEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        Etudiant e = EtudiantRepository.findById(Long.valueOf(etudiantId)).get();
        e.setDepartement(null);
        EtudiantRepository.save(e);
    }

    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e,Integer idContrat,Integer idEquipe){
        Contrat c =ContratRepository.findById(Long.valueOf(idContrat)).get();
        Equipe eq =EquipeRepository.findById(Long.valueOf(idEquipe)).get();
        e= EtudiantRepository.save(e);
        c.setEtudiant(e);
        ContratRepository.save(c);
        eq.getEtudiantSet().add(e);
        EquipeRepository.save(eq);
        return e;
    }

    public Set<Etudiant> getEtudiantByDepAndUni(Departement Departement, Universite Universite){
        List<Departement> departementslist = (List<Departement>) Universite.getDepart();
        for (Departement i:departementslist) {
            if(Departement.equals(i)) {
                Set<Etudiant> etu = EtudiantRepository.getEtudiantsByDepartement(Departement.getIdDepartement());
                return etu;
            }
        }
        return null;
    }

    public Set<Contrat> getEtudiantContrats (Long idUser){
        Etudiant e = EtudiantRepository.findById(idUser).get();
        return e.getContratSet();
    }

    public Set<Equipe> getEtudiantEquipes (Long idUser){
        Etudiant e = EtudiantRepository.findById(idUser).get();
        return e.getEquipeSet();
    }

    public Set<Equipe> AssignEquipeEtudiant (Long idUser){
        Etudiant e = EtudiantRepository.findById(idUser).get();
        return e.getEquipeSet();
    }

    public Etudiant AssignContratEtudiant (long idUser,long idContrat){
        Etudiant e = EtudiantRepository.findById(idUser).get();
        Contrat c = ContratRepository.findById(idContrat).get();
        c.setEtudiant(e);
        ContratRepository.save(c);
        e.getContratSet().add(c);
        return null;
    }

    public Etudiant AssignEquipeEtudiant(long idUser,long idEquipe){
        Etudiant e = EtudiantRepository.findById(idUser).get();
        Equipe eq = EquipeRepository.findById(idEquipe).get();

        e.getEquipeSet().add(eq);
        eq.getEtudiantSet().add(e);
        EtudiantRepository.save(e);
        EquipeRepository.save(eq);
        return e;
    }
}
