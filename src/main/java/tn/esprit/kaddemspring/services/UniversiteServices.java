package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.Departement;
import tn.esprit.kaddemspring.model.Universite;

import java.util.List;

public interface UniversiteServices {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);

    void removeUniversite (long idUniversite);


    public void assignUniversiteToDepartement(long idUniversite, long
            idDepartement);

    public List<Departement> retrieveDepartementsByUniversite(long idUniversite);

}
