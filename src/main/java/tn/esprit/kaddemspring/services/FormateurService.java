package tn.esprit.kaddemspring.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.Formateur;
import tn.esprit.kaddemspring.repository.FormateurRepository;

import java.util.List;

@Service
@Slf4j
public class FormateurService implements IFormateurService {

    @Autowired //ou @Inject Formateur repository
    FormateurRepository Fr;


    //**************************************************************************************

    //Ajouuuut
    @Override
    public Formateur addFormateur(Formateur f) {
        return Fr.save(f);
    }

    @Override
    public List<Formateur> addFormateur(List<Formateur> listFormateur) {
        return Fr.saveAll(listFormateur);
    }


    //**************************************************************************************
    //afficher lise Formateur
    @Override
    public List<Formateur> findFormateurList() {
        return Fr.findAll();
    }


    //recherche un formateur avec id
    @Override
    public Formateur findFormateurById(Long id) {
        return Fr.findById(id).orElse(new Formateur());
    }


    //update Formateur
    @Override
    public Formateur updateFormateur(Formateur f) {
        return Fr.save(f);
    }

    @Override
    public List<Formateur> updateFormateur(List<Formateur> listFormateur) {
        return Fr.saveAll(listFormateur);
    }


    //supprimer un Formateur avec id

    @Override
    public void deleteFormateur(Formateur f) {
        Fr.delete(f);
    }

    @Override
    public void deleteFormateur(Long id) {
        Fr.deleteById(id);
    }




}
