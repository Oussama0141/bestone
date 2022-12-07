package tn.esprit.kaddemspring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.Departement;
import tn.esprit.kaddemspring.model.Universite;
import tn.esprit.kaddemspring.repository.DepartementRepository;
import tn.esprit.kaddemspring.repository.UniversiteRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class UniversiteServicesImpl implements UniversiteServices {

    @Autowired
    public UniversiteRepository UniversiteRepository;

    @Autowired
    DepartementRepository departrepo ;

    @Override
    public List<Universite> retrieveAllUniversites() {

        return UniversiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return UniversiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {

        return UniversiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {

        return UniversiteRepository.findById(idUniversite).get();
    }

    @Override
    public void removeUniversite(long idUniversite) {
        UniversiteRepository.deleteById(idUniversite);
    }

    @Override
    public void assignUniversiteToDepartement(long idUniversite, long idDepartement) {

        if(!departrepo.existsById(idDepartement)) {
            log.info("depart dont exist");
        }
        if(!UniversiteRepository.existsById(idUniversite)) {
            log.info("universite dont exist");
        }
        Universite univ =UniversiteRepository.findById(idUniversite).get();

        univ.getDepart().add(departrepo.findById(idDepartement).get());

        UniversiteRepository.save(univ);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(long idUniversite) {
        Universite univ=UniversiteRepository.findById(idUniversite).get();

        return univ.getDepart();
    }

}
