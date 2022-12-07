package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.Departement;

import java.util.List;

public interface DepartementServices {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (long idDepart);

    void removeDepartement(long idDepart);
}
