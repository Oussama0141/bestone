package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.Support;

import java.util.List;

public interface ISupportService {
    ////ajout Support
    Support addSupport(Support s);
    List<Support> addSupport(List<Support> listSupport);

    List<Support> findSupportList();

    //recherche un support
    Support findSupportById (Long id);
    Support updateSupport (Support s);
    List<Support> updateSupport (List<Support> listSupport);



    //supprimer un Support avec id

    void deleteSupport(Long id);
    void deleteSupport(Support s);
}
