package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.SkillRepository;
import com.metacube.training.service.interfaces.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private EmployeeRepository<Employee> employeeRepository;
	
	@Autowired
	SkillRepository skillRepository;

	@Override
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	@Override
	public boolean createSkill(Skill skill) {
		skillRepository.save(skill);
		return true;
	}

	@Override
	public List<Employee> getEmployeesBySkills(String skill) {	
		return employeeRepository.getEmployeeBySkill(skill);
	}
}
