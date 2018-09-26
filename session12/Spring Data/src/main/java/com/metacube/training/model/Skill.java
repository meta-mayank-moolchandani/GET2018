package com.metacube.training.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skill_master")
public class Skill {
	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "skill_name")
	private String name;

	
	@ManyToMany(mappedBy = "skills",cascade =  CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<EmployeeModel> employeeModels = new HashSet<>();

	
	public Set<EmployeeModel> getEmployees() {
		return employeeModels;
	}

	public void setEmployees(Set<EmployeeModel> employeeModels) {
		this.employeeModels = employeeModels;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
