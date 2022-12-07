package tn.esprit.kaddemspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddemspring.model.Support;

@Repository
public interface SupportRepository extends JpaRepository<Support, Long> {
    //  List<Support> findByList(long clubId);







}
