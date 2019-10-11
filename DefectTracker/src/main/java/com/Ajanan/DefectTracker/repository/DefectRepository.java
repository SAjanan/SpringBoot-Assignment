package com.Ajanan.DefectTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ajanan.DefectTracker.model.Defect;

public interface DefectRepository extends JpaRepository<Defect, String> {
	public List<Defect> findByProjectId(String project_id);
	
	public List<Defect> findByUserId(String user_id);
	
	public List<Defect> findByStatus(String status);
	
	public List<Defect> findBySeverityChoices(String severityChoices);
	
	public List<Defect> findByPriorityChoices(String priorityChoices);
	
	public Defect findByDefectId(String defectId);

}
