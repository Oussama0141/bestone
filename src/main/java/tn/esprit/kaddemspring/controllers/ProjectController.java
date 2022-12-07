package tn.esprit.kaddemspring.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Project;
import tn.esprit.kaddemspring.services.IProjectService;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("controllerProjet")
public class ProjectController {


    @Autowired
    IProjectService projectService ;

    @PostMapping("/add")
    @ResponseBody
    public Project addProject(@RequestBody Project pr) { return projectService.addProject(pr) ;
    }

    @PutMapping ("/update")
    public Project updateProject(@RequestBody Project pr){ return projectService.updateProject(pr);
    }


    @GetMapping("/retrieveAllProjects")
    @ResponseBody
    public List<Project> retrieveAllProjects() {
        return  projectService.retrieveAllProjects();
    }

    @GetMapping("/get/{idProject}")
    public Project getById(@PathVariable("idProject") Integer id){
        return projectService.retrieveProject(id);
    }

    @DeleteMapping("/remove/{idProject}")
    public void removeProject(@PathVariable("idProject") Integer id){
        projectService.removeProject(id);
    }


   // @PostMapping("/affectProjectToEtudiant/{nomE}/{prenomE}")
   // public Project affectProjectToEtudiant(@RequestBody Project pr, @PathVariable("prenomE") String prenomE,@PathVariable("nomE") String nomE) {
        //Project project = projectService.affectProjectToEtudiant(pr, nomE, prenomE);
       // return project;
   // }

    @GetMapping("/nbrProjetsValides/{start}/{end}")
    Integer nbProjetsValides(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start , @PathVariable("end")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date end) {
        return projectService.nbProjectsValides(start,end) ;
    }



}
