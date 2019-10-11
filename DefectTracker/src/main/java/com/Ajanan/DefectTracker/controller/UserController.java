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
import com.Ajanan.DefectTracker.model.User;
import com.Ajanan.DefectTracker.repository.DefectRepository;
import com.Ajanan.DefectTracker.repository.UserRepository;

@RestController
@RequestMapping("/ajanan/assi")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DefectRepository defectRepository;
	
	
	//Add User
	@PostMapping(value="/user")
	public void addUser(
			@RequestBody User user){
		userRepository.save(user);
	}
	
	
	//Get All Users
	@GetMapping(value="/user")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	
	//Get User By User Id
	@GetMapping(value="/user/{id}")
	public User getUserByUserId(
			@PathVariable String id){
		return userRepository.findByUserId(id);
	}
	
	
	//Add Project to User
	@PostMapping(value="/user/{uid}/add_project/{project_id}")
	public void addProject(@PathVariable String user_id, @PathVariable String project_id) {
		User user = getUserByUserId(user_id);
		user.setProjectId(project_id);
		user.setProject(new Project(project_id,"",""));
		userRepository.save(user);
	}
	
	//Remove Project From User
	@PostMapping(value="/user/{user_id}/remove_project")
	public void removeProject(@PathVariable String user_id) {
		User user = getUserByUserId(user_id);
		user.setProjectId(null);
		user.setProject(null);
		userRepository.save(user);
	}

}
