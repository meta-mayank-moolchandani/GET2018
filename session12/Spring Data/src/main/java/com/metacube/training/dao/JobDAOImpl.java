package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.connection.Connect;
import com.metacube.training.dao.daointerfaces.JobDAO;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;

@Repository
@Transactional
public class JobDAOImpl implements JobDAO{
	
	/*@Autowired
	private SessionFactory sessionFactory;*/
	
	private final String SQL_GET_ALL = "select * from job_title_master";
	private final String SQL_INSERT_JOB = "insert into job_title_master(job_title) values(?)";
	
	@Override
	public JobTitle getJobById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobTitle> getAllJobs() {
		List<JobTitle> resultList = new ArrayList<JobTitle>();
		try(
				Connection connect = Connect.getConnection();
				PreparedStatement stmt =  connect.prepareStatement(SQL_GET_ALL);)
			{
				ResultSet rset =  stmt.executeQuery();
				while(rset.next())
				{
					int id = rset.getInt("job_code");
					String title = rset.getString("job_title");
					JobTitle newJob = new JobTitle();
					newJob.setId(id);;
					newJob.setName(title);
					resultList.add(newJob);
				}
			}catch(SQLException e)
		{
				e.fillInStackTrace();
		}	
		/*TypedQuery<JobTitle> query = sessionFactory.getCurrentSession().createQuery("from JobTitle");
		return query.getResultList();*/
		return resultList;
	}

	@Override
	public boolean deleteJob(JobTitle jobTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateJob(JobTitle jobTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createJob(JobTitle jobTitle) {
		boolean created =false;
		try(
				Connection connect = Connect.getConnection();
				PreparedStatement stmt =  connect.prepareStatement(SQL_INSERT_JOB);)
			{
				stmt.setString(1, jobTitle.getName());
			    stmt.executeUpdate();
				created = true;
			}catch(SQLException e)
		{
				created = false;
		}	
		return created;
		/*sessionFactory.getCurrentSession().save(job);
		return true;*/
	}

}
