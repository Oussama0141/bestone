package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.Project;

import java.util.Date;
import java.util.List;

public interface IProjectService {


    Project addProject (Project pr);

    Project updateProject (Project pr);

    List<Project> retrieveAllProjects();

    Project retrieveProject (Integer idProject);

    void removeProject(Integer idProject);

   // Project affectProjectToEtudiant (Project pr, String nomE,String prenomE);

    Integer nbProjectsValides(Date startDate, Date endDate);



}
