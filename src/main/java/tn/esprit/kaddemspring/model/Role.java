package tn.esprit.kaddemspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRole;
    private TypeRole typeRole;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private Set<Utilisateur> Utilisateur;
}
