package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.ServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestCaseAssignmentApplicationTests {

	@Autowired
	private ServiceImpl serviceImpl;

	@MockBean
	private EmployeeRepo employeeRepo;

	@Test
	public void getAllDetailsTest() {
		when(employeeRepo.findAll()).thenReturn(Stream
				.of(new Employee(1, "Vinay", "111"), new Employee(2, "kumar", "112"), new Employee(3, "priya", "113"))
				.collect(Collectors.toList()));
		assertEquals(3, serviceImpl.getAllDetails().size());
	}

	@Test
	public void getDetailsByIdTest() {
		when(employeeRepo.findById(1))
				.thenReturn(Stream.of(new Employee(1, "Vinay", "111")).collect(Collectors.toList()));
		assertEquals(1, serviceImpl.getDetailsById(1).size());
	}

	@Test
	public void saveTest() {
		Employee obj = new Employee(1, "Vinay", "111");
		when(employeeRepo.save(obj)).thenReturn(obj);
		assertEquals(obj, serviceImpl.saveDetails(obj));
	}

	@Test
	public void deleteTest() {
		serviceImpl.deleteById(1);
		verify(employeeRepo,times(1)).deleteById(1);
	}
	
}
