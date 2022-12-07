package tn.esprit.kaddemspring.model;

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

public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReclamation;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String title;
    private String message;
    private boolean processed;

    @ManyToOne
    Etudiant etudiant;

}