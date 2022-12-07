package tn.esprit.kaddemspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant extends Utilisateur implements Serializable {

    @Enumerated(EnumType.STRING)
    private Domaine domaine;
    @ManyToOne()
    private Departement departement;
    @OneToMany(mappedBy = "etudiant")
    private Set<Contrat> ContratSet;
    @ManyToMany(mappedBy = "EtudiantSet",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Equipe> EquipeSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    @JsonIgnore
    private Set<Project> projects;

}
