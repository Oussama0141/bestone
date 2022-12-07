package tn.esprit.kaddemspring.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser ;
    String nom;
    String prenom;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    Date lastModifiedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;
}
