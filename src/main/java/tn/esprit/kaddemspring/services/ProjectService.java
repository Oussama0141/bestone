package tn.esprit.kaddemspring.services;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.Project;
import tn.esprit.kaddemspring.repository.ProjectRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService implements IProjectService {



    @Autowired
    ProjectRepository projectrepo;

    //EtudiantRepository edtREpo;

    @Override
    public Project addProject(Project pr) {
        return projectrepo.save(pr);
    }

    @Override
    public Project updateProject(Project pr) {
        return projectrepo.save(pr);
    }

    @Override
    public List<Project> retrieveAllProjects() {
        return (List<Project>) projectrepo.findAll();
    }

    @Override
    public Project retrieveProject(Integer idProject) {
        return projectrepo.findById(idProject).get();
    }


    @Override
    public void removeProject(Integer idProject) { projectrepo.deleteById(idProject); }

    //public Project affectProjectToEtudiant(Project pr, String nomE, String prenomE) {
      //  Etudiant etudiant=edtREpo.findByNomEAndPrenomE(nomE,prenomE);
       // Project project=projectrepo.save(pr);
      //  project.setEtudiant(etudiant);
       // edtREpo.save(etudiant);
       // return project;
     //}
    @Override
    public Integer nbProjectsValides(Date startDate, Date endDate) {
        return projectrepo.valideProjectsBetween2dates(startDate,endDate);
    }
}
