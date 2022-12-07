package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.Formateur;

import java.util.List;

public interface IFormateurService {


    ////ajout Formateur
    Formateur addFormateur(Formateur f);
    List<Formateur> addFormateur(List<Formateur> listFormateur);

    List<Formateur> findFormateurList();

    //recherche un Devoir
    Formateur findFormateurById (Long id);
    Formateur updateFormateur (Formateur f);
    List<Formateur> updateFormateur (List<Formateur> listFormateur);



    //supprimer un etudiant avec id

    void deleteFormateur(Long id);
    void deleteFormateur(Formateur f);

}
