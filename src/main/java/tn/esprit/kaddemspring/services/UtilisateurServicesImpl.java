package tn.esprit.kaddemspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.Utilisateur;
import tn.esprit.kaddemspring.repository.EtudiantRepository;
import tn.esprit.kaddemspring.repository.UtilisateurRepository;

import java.util.List;

@Service
public class UtilisateurServicesImpl implements UtilisateurServices{

    @Autowired
    UtilisateurRepository utilisateurRepository;


    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> findAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    @Override
    public void deleteUtilisateurById(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public Utilisateur UpdateUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur GetUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }






}
