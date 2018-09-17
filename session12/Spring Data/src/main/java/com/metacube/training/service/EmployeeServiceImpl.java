package com.metacube.training.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.daointerfaces.EmployeeDAO;
import com.metacube.training.model.EmployeeModel;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.JobDetailsRepository;
import com.metacube.training.repository.SkillRepository;
import com.metacube.training.service.serviceinterface.EmployeeService;
import com.metacube.training.transferObjects.EmployeeForgotPassword;
import com.metacube.training.transferObjects.EmployeeSkills;
import com.metacube.training.transferObjects.EmployeeTransferObject;
import com.metacube.training.transferObjects.EmployeeTransferObjectWithJobDetails;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeedao;


	@Autowired
    private EmployeeRepository<EmployeeModel> employeeRepository;
	
	@Autowired
    private SkillRepository<Skill> skillRepository;
	
	@Autowired
    private JobDetailsRepository<JobDetails> jobDetailsRepository;
	
	@Override
	public EmployeeModel getEmployeeById(String empCode) {
		return employeeRepository.findOne(empCode);
	}

	@Override
	public List<EmployeeTransferObject> getAllEmployeeTransferObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean disableEmployee(String empCode) {
		EmployeeModel employeeModel = employeeRepository.findOne(empCode);
		if(employeeModel!=null)
		{
			employeeModel.setEnabled(true);
			try{
				employeeRepository.save(employeeModel);
			}catch(Exception e)
			{
				e.printStackTrace();
				return true;
			}
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean enableEmployee(String empCode) {
		EmployeeModel employeeModel = employeeRepository.findOne(empCode);
		if(employeeModel!=null)
		{
			employeeModel.setEnabled(true);
			try{
				employeeRepository.save(employeeModel);
			}catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean updateEmployee(EmployeeModel employeeModel) {
		// TODO Auto-generated method stub
		try{
			employeeRepository.save(employeeModel);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean createEmployee(EmployeeTransferObjectWithJobDetails employeeTransferObject) {
		employeeTransferObject.setEmpCode(this.getEmpCode());
		EmployeeModel employeeModel = new EmployeeModel(employeeTransferObject);
		JobDetails jobDetails = new JobDetails(employeeTransferObject);
		try{
			employeeRepository.save(employeeModel);
			jobDetailsRepository.save(jobDetails);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private String getEmpCode() {
		String lastEmployeeCode = (employeedao.getLastEmployeeCode());
		int currYear;
		if(lastEmployeeCode!=null || !(lastEmployeeCode.equals("")))
        {
			String subLastEmployeeCode[] = lastEmployeeCode.split("/");
			int year = Integer.parseInt(subLastEmployeeCode[0].substring(1));
			int code = Integer.parseInt(subLastEmployeeCode[1].substring(1));
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			int currentYear = c.get(Calendar.YEAR);
			currYear = currentYear;
			if(currentYear!=year)
			{
				return ("E"+currentYear+"/C1000");
			}
			else
			{
				return ("E"+year+"/C"+(code+1));
			}
        }
		return null;
	}

	@Override
	public boolean createJobDetails(EmployeeTransferObjectWithJobDetails employeeTransferObject) {
		JobDetails jobDetails = new JobDetails(employeeTransferObject);
	   jobDetailsRepository.save(jobDetails);
	   return true;
	}

	@Override
	public List<EmployeeModel> getTeamLeaders() {
		
		return employeedao.getTeamLeaders();
	}

	@Override
	public List<EmployeeModel> getManagers() {
		// TODO Auto-generated method stub
		return employeedao.getManagers();
	}

	@Override
	public EmployeeModel findUserByEmail(String employeeEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveForgotEmployee(EmployeeForgotPassword employeeForgotPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmployeeForgotPassword findUserByResetToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteToken(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addSkills(EmployeeSkills employee) {
		EmployeeModel newEmployee = employeeRepository.findOne(employee.getEmpCode());
		List<Skill> skillSet=  skillRepository.findAll();
		Set<Skill>skillSet2 = new HashSet<Skill>(skillSet);
		newEmployee.setSkills(skillSet2);
		employeeRepository.save(newEmployee);
		return false;
	}
	
	
}
