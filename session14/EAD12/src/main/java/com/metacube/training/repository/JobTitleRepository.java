package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobTitle;

public interface JobTitleRepository<J> extends JpaRepository<JobTitle, Long>{
	public JobTitle getJobTitleByJobTitle(String jobTitle);
}
