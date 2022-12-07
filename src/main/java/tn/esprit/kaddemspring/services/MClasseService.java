package tn.esprit.kaddemspring.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.MClasse;
import tn.esprit.kaddemspring.model.Support;
import tn.esprit.kaddemspring.repository.MClasseRepository;

import java.util.List;

@Service
@Slf4j
public class MClasseService implements IMClasseService {


    @Autowired //ou @Inject Formateur repository
    MClasseRepository MCr;


    //**************************************************************************************

    //Ajouuuut
    @Override
    public MClasse addMClasse(MClasse mc) {
        return MCr.save(mc);
    }

    @Override
    public List<MClasse> addMClasse(List<MClasse> listMClasse) {
        return MCr.saveAll(listMClasse);
    }


    //**************************************************************************************
    //afficher lise MClasse
    @Override
    public List<MClasse> findMClasseList() {
        return MCr.findAll();
    }


    //recherche un MClasse avec id
    @Override
    public MClasse findMClasseById(Long id) {
        return MCr.findById(id).orElse(new MClasse());
    }


    //update MClasse
    @Override
    public MClasse updateMClasse(MClasse mc) {
        return MCr.save(mc);
    }


    @Override
    public List<MClasse> updateMClasse(List<MClasse> listMClasse) {
        return MCr.saveAll(listMClasse);
    }


    //supprimer un MClasse avec id

    @Override
    public void deleteMClasse(MClasse mc) {
        MCr.delete(mc);
    }

    @Override
    public void deleteMClasse(Long id) {
        MCr.deleteById(id);
    }


    @Override
    public List<Support> getSupportsByMClasse(Integer id) {
        return MCr.getSupportsByMClasse(id);
    }
}