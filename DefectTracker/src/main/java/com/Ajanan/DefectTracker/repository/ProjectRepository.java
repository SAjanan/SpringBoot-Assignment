package com.Ajanan.DefectTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ajanan.DefectTracker.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String>{
	public Project findByProjectId(String projectId);
}