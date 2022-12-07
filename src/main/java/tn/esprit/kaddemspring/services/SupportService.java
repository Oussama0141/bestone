package tn.esprit.kaddemspring.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.Support;
import tn.esprit.kaddemspring.repository.SupportRepository;

import java.util.List;

@Service
@Slf4j
public class SupportService implements ISupportService {


    @Autowired //ou @Inject Formateur repository
    SupportRepository Sr;


    //**************************************************************************************

    //Ajouuuut
    @Override
    public Support addSupport(Support s) {
        return  Sr.save(s);
    }

    @Override
    public List<Support> addSupport(List<Support> listSupport) {
        return Sr.saveAll(listSupport);
    }


    //**************************************************************************************
    //afficher lite Support
    @Override
    public List<Support> findSupportList() {
        return Sr.findAll();
    }



    //recherche un Support avec id
    @Override
    public Support findSupportById(Long id) {
        return Sr.findById(id).orElse(new Support());
    }


    //update Support
    @Override
    public Support updateSupport(Support s) {
        return Sr.save(s);
    }


    @Override
    public List<Support> updateSupport(List<Support> listSupport) {
        return Sr.saveAll(listSupport);
    }



    //supprimer un Support avec id

    @Override
    public void deleteSupport(Support s) {
        Sr.delete(s);
    }
    @Override
    public void deleteSupport(Long id) {
        Sr.deleteById(id);
    }











}
