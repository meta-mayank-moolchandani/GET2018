package com.metacube.training.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeAndJobDetails;
import com.metacube.training.model.JobDetails;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.JobDetailsRepository;
import com.metacube.training.service.interfaces.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private JobDetailsRepository JobDetailsRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean toggleActivation() {
		return false;
	}

	@Override
	public boolean createEmployee(EmployeeAndJobDetails employeeAndJobDetails) {
		Employee employeeModel = getEmployeeObjectByTransferObject(employeeAndJobDetails);
		employeeRepository.save(employeeModel);
		return true;
	}

	@Override
	public String getGeneratedEmployeeCode() {
		//String lastEmpCode = employeeDAO.getLastAddedEmployee().getEmpCode();
		String lastEmpCode = employeeRepository.getLastAddedEmployee().getEmpCode();
		
		String newGeneratedCode = "";
		String year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
		NumberFormat nf = new DecimalFormat("0000");

		if (lastEmpCode == null || "".equals(lastEmpCode)) {
			newGeneratedCode = "E" + year + "/" + nf.format(0);
		} else {
			int integerCode = Integer.parseInt(lastEmpCode.split("/")[1]);
			newGeneratedCode = "E" + year + "/" + nf.format(integerCode + 1);
		}

		return newGeneratedCode;

	}

	@Override
	public List<Employee> getTeamLeaders() {
		
		return employeeRepository.getJobTitle("Team Leader");
	}

	@Override
	public List<Employee> getManagers() {
		return employeeRepository.getJobTitle("Manager");
	}

	@Override
	public boolean addJobDetails(EmployeeAndJobDetails employeeAndJobDetails) {
		JobDetails jobDetails = getJobDetailObject(employeeAndJobDetails);
		JobDetailsRepository.save(jobDetails);
		return true;
	}

	@Override
	public Employee getEmployeeById(EmployeeAndJobDetails employeeAndJobDetails) {
		Employee employeeModel = getEmployeeObjectByTransferObject(employeeAndJobDetails);
		Employee employeeInDatabase = (Employee) employeeRepository.findOne(employeeModel.getEmpCode());
		boolean validateEmployeeFlag = false;
		if (employeeInDatabase != null) {
			if ((employeeAndJobDetails.getEmpCode().equals(employeeInDatabase.getEmpCode()))
					&& (employeeAndJobDetails.getPassword().equals(employeeInDatabase.getPassword()))) {
				validateEmployeeFlag = true;
			}
		}
		System.out.println("passwor:" + validateEmployeeFlag);

		if (validateEmployeeFlag) {
			return employeeInDatabase;
		} else {
			return null;
		}
	}

	@Override
	public Employee getEmployeeByIdString(String empCode) {
		EmployeeAndJobDetails employeeAndJobDetails = new EmployeeAndJobDetails();
		
		employeeAndJobDetails.setEmpCode(empCode);
		Employee employeeModel = getEmployeeObjectByTransferObject(employeeAndJobDetails);
		
		return (Employee) employeeRepository.findOne(empCode);
		
		
		
	}
	
	
	private Employee getEmployeeObjectByTransferObject(
			EmployeeAndJobDetails employeeAndJobDetails) {
		Employee employee = new Employee();

		employee.setDob(employeeAndJobDetails.getDob());
		employee.setEmailId(employeeAndJobDetails.getEmailId());
		employee.setEmpCode(employeeAndJobDetails.getEmpCode());
		employee.setEnabled(employeeAndJobDetails.isEnabled());
		employee.setFirstName(employeeAndJobDetails.getFirstName());
		employee.setGender(employeeAndJobDetails.getGender());
		employee.setLastName(employeeAndJobDetails.getLastName());
		employee.setPassword(employeeAndJobDetails.getPassword());
		employee.setPrimaryContactNumber(employeeAndJobDetails
				.getPrimaryContactNumber());
		employee.setProfilePicture(employeeAndJobDetails.getProfilePicture());
		employee.setSecondaryContactNumber(employeeAndJobDetails
				.getSecondaryContactNumber());
		employee.setSkypeId(employeeAndJobDetails.getEmailId());

		return employee;

	}
	
	private JobDetails getJobDetailObject(EmployeeAndJobDetails employeeAndJobDetails){
		JobDetails jobDetails = new JobDetails();
		jobDetails.setCurrentProjectId(jobDetails.getCurrentProjectId());
		jobDetails.setEmpCode(employeeAndJobDetails.getEmpCode());
		jobDetails.setJobCode(Integer.parseInt(employeeAndJobDetails.getJobTitle()));
		jobDetails.setReportingManager(employeeAndJobDetails.getManager());
		jobDetails.setTeamLead(employeeAndJobDetails.getTeamLeader());
		return jobDetails;
	}
	@Override
	public boolean updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		return true;
	}
}

