package com.metacube.training.service.serviceinterface;

import java.util.List;

import com.metacube.training.model.JobTitle;

public interface JobService {
		
	JobTitle getJobById(Long id);

	List<JobTitle> getAllJobs();

	boolean deleteJob(Long id);

	boolean updateJob(JobTitle jobTitle);

	boolean createJob(JobTitle jobTitle);

}
