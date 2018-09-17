package com.metacube.training.dao.daointerfaces;

import java.util.List;

import com.metacube.training.model.JobTitle;



public interface JobDAO {
	JobTitle getJobById(Long id);

	List<JobTitle> getAllJobs();

	boolean deleteJob(JobTitle jobTitle);

	boolean updateJob(JobTitle jobTitle);

	boolean createJob(JobTitle jobTitle);
	
}
