package tn.esprit.kaddemspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddemspring.model.Project;

import java.util.Date;
@Repository
public interface ProjectRepository extends JpaRepository <Project, Integer> {

    @Query("SELECT count(p) FROM Project p WHERE  p.dateDebutP>=?1 and p.dateFinP<=?2 and p.selection=true")
    Integer valideProjectsBetween2dates(Date startDate, Date endDate);


}
