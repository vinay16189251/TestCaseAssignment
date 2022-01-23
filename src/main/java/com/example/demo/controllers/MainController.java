package com.example.demo.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.ServiceImpl;

@RestController
public class MainController {

	@Autowired
	private ServiceImpl serviceImpl;

	@PostMapping("/save")
	public Employee saveDetails(@RequestBody Employee employee) {
		System.out.println("" + employee.toString());
		return serviceImpl.saveDetails(employee);
	}

	@GetMapping("/allDetails")
	public List<Employee> getAllDetails() {

		return serviceImpl.getAllDetails();
	}

	@GetMapping("/get/{id}")
	public List<Employee> getById(@PathParam(value = "id") int id) {

		return serviceImpl.getDetailsById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathParam(value = "id") int id) {

		serviceImpl.deleteById(id);
	}
}
