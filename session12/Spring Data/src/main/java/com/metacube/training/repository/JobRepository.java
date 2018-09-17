package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.JobTitle;

public interface JobRepository<J> extends JpaRepository<JobTitle, Long>{

}
