package tn.esprit.kaddemspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutC;
    @Temporal(TemporalType.DATE)
    private Date dateFinC;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private boolean archive;
    private float MontantC;
    @JsonIgnore
    @ManyToOne()
    private Etudiant etudiant;




}
