package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
@Service
public class ServiceImpl {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee saveDetails(Employee employee) {

		return employeeRepo.save(employee);
	}

	public List<Employee> getAllDetails() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	public List<Employee> getDetailsById(int id) {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepo.findById(id);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(id);
		 
	}

}
