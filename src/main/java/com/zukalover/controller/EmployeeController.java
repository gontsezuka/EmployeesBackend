package com.zukalover.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zukalover.model.Employee;
import com.zukalover.service.EmployeeService;

@RestController
@RequestMapping("/employees/")
@CrossOrigin("http://localhost:8080")
public class EmployeeController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("find-all")
	public ResponseEntity<List<Employee>> findAllEmployees()
	{
		LOGGER.info("RETRIEVE ALL EMPLOYEE ENDPOINT REACHED");
		return new ResponseEntity<>(employeeService.findAllEmployees(),HttpStatus.OK);
	}
	
	@GetMapping("find-by-id/{employeeid}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable("employeeid")Long employeeId)
	{
		LOGGER.info("FIND BY ID ENDPOINT REACHED");
		return new ResponseEntity<>(employeeService.findEmployeeByID(employeeId),HttpStatus.OK);
	}
	
	
	@PostMapping("save-employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		LOGGER.info("SAVE EMPLOYEE ENDPOINT REACHED");
		return new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.OK);
	}
	
	@PutMapping("update-employee")
	public void updateEmployee(@RequestBody Employee employee)
	{
		employeeService.updateEmployee(employee);
	}
	
	@PutMapping("update-employee-return")
	public ResponseEntity<Employee> updateReturnEmployee(@RequestBody Employee employee)
	{
	  return new ResponseEntity<>(employeeService.updateReturn(employee),HttpStatus.OK);
	}
	
	@DeleteMapping("delete-employee/{employeeid}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("emoloyeeid")Long employeeId)
	{
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
