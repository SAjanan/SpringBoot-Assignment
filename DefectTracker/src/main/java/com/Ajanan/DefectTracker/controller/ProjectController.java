package com.Ajanan.DefectTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ajanan.DefectTracker.model.Project;
import com.Ajanan.DefectTracker.repository.DefectRepository;
import com.Ajanan.DefectTracker.repository.ProjectRepository;

@RestController
@RequestMapping("/ajanan/assi")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	DefectRepository defectRepository;
	
	
	//Add Project
	@PostMapping(value="/project")
	public void addProject(
			@RequestBody Project project){
		projectRepository.save(project);
	}
	
	
	//Get All Projects
	@GetMapping(value="/project")
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	
	//Get Project By Project Id
	@GetMapping(value="/project/{id}")
	public Project getProjectById(
			@PathVariable String id){
		return projectRepository.findByProjectId(id);
	}
	
}