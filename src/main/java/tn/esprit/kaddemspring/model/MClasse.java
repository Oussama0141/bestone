package tn.esprit.kaddemspring.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MClasse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="idMClasse")
    long idMClasse;


    @Column(name="matiere")
    String matiere;

    @Column(name="classe")
    String classe;

    @Column(name="emailF")
    String emailF;
    @Column(name="description")
    String description;



    String imageUrl;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Date date;

    @PrePersist
    private void onCreate()
    {
        date=new Date();
    }




    @OneToMany(mappedBy = "mClasse" ,cascade = CascadeType.ALL)
    List<Support> supports ;


    @ManyToOne
    Formateur formateur;

}
