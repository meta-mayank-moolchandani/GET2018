package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.daointerfaces.JobDAO;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;
import com.metacube.training.repository.JobRepository;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.service.serviceinterface.JobService;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private JobDAO jobDAO;
	
	@Autowired
    private JobRepository<JobTitle> jobRepository;

	@Override
	public boolean deleteJob(Long id) {
		return false;
	}


	@Override
	public JobTitle getJobById(Long id) {
		
		return jobRepository.findOne(id);
	}


	@Override
	public boolean updateJob(JobTitle jobTitle) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean createJob(JobTitle jobTitle) {
		try{
			jobRepository.save(jobTitle);
		}catch(Exception e)
		{
			e.fillInStackTrace();
			return false;
		}
		return true;
	}


	@Override
	public List<JobTitle> getAllJobs() {
		return jobRepository.findAll();
	}
}
