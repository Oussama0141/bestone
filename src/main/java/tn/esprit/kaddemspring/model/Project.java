package tn.esprit.kaddemspring.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Project")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Project implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProject")
    private int idProject;
    @Column(name = "nomProject")
    private String NomProjet;
    @Temporal(TemporalType.DATE)
    private Date dateDebutP;
    @Temporal(TemporalType.DATE)
    private Date dateFinP;
    @Enumerated(EnumType.STRING)
    private Module module;
    @Column(name = "nomEnseignant")
    private String NomEnseignant;
    private Boolean selection;
    @ManyToOne
    @JsonIgnore
    Etudiant etudiant;







}
