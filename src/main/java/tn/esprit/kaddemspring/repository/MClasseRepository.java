package tn.esprit.kaddemspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddemspring.model.MClasse;
import tn.esprit.kaddemspring.model.Support;

import java.util.List;

@Repository
public interface MClasseRepository extends JpaRepository<MClasse, Long> {


    @Query("select mc.supports from MClasse mc where mc.idMClasse =?1")
    List<Support> getSupportsByMClasse (Integer idMclasse);

}
