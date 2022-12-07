package tn.esprit.kaddemspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailsEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailsEquipe;
    private int salle;
    private String thematique;



}
