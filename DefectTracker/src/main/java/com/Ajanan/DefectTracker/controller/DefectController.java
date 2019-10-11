package com.Ajanan.DefectTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ajanan.DefectTracker.model.Defect;
import com.Ajanan.DefectTracker.model.Project;
import com.Ajanan.DefectTracker.model.User;
import com.Ajanan.DefectTracker.repository.DefectRepository;

@RestController
	@RequestMapping("/ajanan/assi")
	public class DefectController {
		
		@Autowired
		DefectRepository defectRepository;
		
		
		//Add Defect
		@PostMapping(value="/defect")
		public void addDefect(@RequestBody Defect defect){
			defect.setProject(new Project(defect.getProjectId(),"",""));
			defectRepository.save(defect);
		}
		
		
		//Get All Defects
		@GetMapping(value="/defect")
		public List<Defect> getAllDefects(){
			return defectRepository.findAll();
		}
		
		
		//Get Defect By Id
		@GetMapping(value="/defect/{id}")
		public Defect getDefectById(@PathVariable String id){
			return defectRepository.findByDefectId(id);
		}
		
		
		//Get Defects By Project Id
		@GetMapping(value="/defect/p/{project_id}")
		public List<Defect> getDefectsByProjectId(@PathVariable String project_id){
			return defectRepository.findByProjectId(project_id);
		}
		
		
		//Get Defects By User Id
		@GetMapping(value="/defect/u/{user_id}")
		public List<Defect> getDefectsByUserId(@PathVariable String user_id){
			return defectRepository.findByUserId(user_id);
		}
		
		
		//Modify Defect
		@PostMapping(value="/defect/update")
		public void updateDefect(@RequestBody Defect defect) {
			defect.setProject(new Project(defect.getProjectId(),"",""));
			defectRepository.save(defect);
		}
		
		
		//Assign User
		@PostMapping(value="/defect/{id}/assign-user/{user_id}")
		public void assignUser(@PathVariable String id, @PathVariable String user_id) {
			Defect defect = getDefectById(id);
			defect.setUserId(user_id);
			defect.setUser(new User(user_id,"",""));
			defectRepository.save(defect);
		}
		
		
		//Change User
		@PostMapping(value="/defect/{id}/change_user/{user_id}")
		public void changeUser(@PathVariable String id, @PathVariable String user_id) {
			Defect defect = getDefectById(id);
			defect.setUserId(user_id);
			defect.setUser(new User(user_id,"",""));
			defectRepository.save(defect);
		}	
		
		
		//Remove User
		@PostMapping(value="/defect/{id}/remove_user")
		public void removeUser(@PathVariable String id) {
			Defect defect = getDefectById(id);
			defect.setUserId(null);
			defect.setUser(null);
			defectRepository.save(defect);
		}
		
		
		//Get Defects By Status
		@GetMapping(value="/defect/status/{status}")
		public List<Defect> getDefectsByStatus(@PathVariable String status){
			return defectRepository.findByStatus(status);
		}
		
		
		//Change the Status of the Defect
		@PostMapping(value="/defect/{id}/change_status/{status}")
		public void changeStatus(@PathVariable String id, @PathVariable String status) {
			Defect defect = getDefectById(id);
			defect.setStatus(status);
			defectRepository.save(defect);
		}
		
		
		//Get Defects By Severity
		@GetMapping(value="/defect/severity/{sev}")
		public List<Defect> getDefectsBySeverity(@PathVariable String sev){
			return defectRepository.findBySeverityChoices(sev);
		}
		
		
		//Get Defects By Priority
		@GetMapping(value="/defect/priority/{pri}")
		public List<Defect> getDefectsByPriority(@PathVariable String pri){
			return defectRepository.findByPriorityChoices(pri);
		}
	}