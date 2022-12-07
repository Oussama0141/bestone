package tn.esprit.kaddemspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.Departement;
import tn.esprit.kaddemspring.model.Equipe;
import tn.esprit.kaddemspring.repository.DepartementRepository;

import java.util.List;


@Service
public class DepartementServicesImpl implements DepartementServices {
    @Autowired
    DepartementRepository departrepo ;


    @Override
    public List<Departement> retrieveAllDepartements() {

        return departrepo.findAll() ;
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departrepo.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {

        return  departrepo.save(d);
    }

    @Override
    public Departement retrieveDepartement(long idDepart) {

        return departrepo.findById(idDepart).get();
    }

    @Override
    public void removeDepartement(long idDepart) {
        departrepo.deleteById(idDepart);
    }

}
