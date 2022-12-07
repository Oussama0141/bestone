package tn.esprit.kaddemspring.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Support implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="idSupport")
    long idSupport;


    @Column(name="description")
    String description;

    @Column(name="idMC")
    long idMC;

    @Column(name="titre")
    String titre;

    @Column(name="text")
    String text;
    @Column(name="type")
    String type;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Date date;

    @PrePersist
    private void onCreate()
    {
        date=new Date();
    }




    @ManyToOne
    MClasse mClasse ;

}
