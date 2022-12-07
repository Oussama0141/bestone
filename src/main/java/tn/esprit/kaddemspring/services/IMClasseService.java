package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.MClasse;
import tn.esprit.kaddemspring.model.Support;

import java.util.List;

public interface IMClasseService {
    ////ajout mclasse
    MClasse addMClasse(MClasse im);
    List<MClasse> addMClasse(List<MClasse> listMClasse);

    List<MClasse> findMClasseList();

    //recherche un mclasse
    MClasse findMClasseById (Long id);
    MClasse updateMClasse (MClasse mc);
    List<MClasse> updateMClasse (List<MClasse> listMClasse);



    //supprimer un MClasse avec id

    void deleteMClasse(Long id);
    void deleteMClasse(MClasse f);

    List<Support> getSupportsByMClasse (Integer id);
}
