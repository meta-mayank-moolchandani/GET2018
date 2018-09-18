package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.service.interfaces.EmployeeSkillService;

@Service 
public class EmployeeSkillServiceImpl implements EmployeeSkillService{

	@Autowired
	EmployeeRepository<Employee> employeeRepository;
	
	@Override
	public void addSkillsToEmployee(String empCode, String[] skillId) {
		Employee employee = employeeRepository.findOne(empCode);
		List<Skill> listOfSkills = new ArrayList<Skill>();

		for(int index = 0;index<skillId.length; index++){
			Skill skill = new Skill();
			skill.setId(Integer.parseInt(skillId[index]));
			listOfSkills.add(skill);
		}
		employee.setSkills(listOfSkills);
		
		employeeRepository.save(employee);

	}

}
