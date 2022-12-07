package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.Utilisateur;

import java.util.List;

public interface UtilisateurServices {
    Utilisateur addUtilisateur(Utilisateur utilisateur);

    List<Utilisateur> findAllUtilisateurs();

    void deleteUtilisateurById(Long id);

    Utilisateur UpdateUtilisateur(Utilisateur utilisateur);

    Utilisateur GetUtilisateurById(Long id);
}
