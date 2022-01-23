package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String empName;
	@Column
	private String empRoll;

	
	public Employee(int id, String empName, String empRoll) {
		super();
		this.id = id;
		this.empName = empName;
		this.empRoll = empRoll;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpRoll() {
		return empRoll;
	}

	public void setEmpRoll(String empRoll) {
		this.empRoll = empRoll;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empRoll=" + empRoll + "]";
	}

}
