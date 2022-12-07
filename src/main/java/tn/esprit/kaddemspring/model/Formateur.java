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

public class Formateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idFormateur")
    long idFormateur;


    @Column(name = "nomPrenom")
    String nomPrenom;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateF")
    Date dateF;

    @Column(name = "matiere")
    String matiere;

    @Column(name = "email")
    String email;

    @Column(name = "phone")
    String phone;

    @Column(name = "imageUrl")
    String imageUrl;


    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Date date;

    @PrePersist
    private void onCreate()
    {
        date=new Date();
    }



    @OneToMany(cascade = CascadeType.ALL, mappedBy="formateur")
    List<MClasse> MClasseList;




}
