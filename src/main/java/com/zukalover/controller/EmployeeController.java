package com.zukalover.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zukalover.model.Employee;
import com.zukalover.service.EmployeeService;

@RestController
@RequestMapping("/employees/")
public class EmployeeController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("find-all")
	public List<Employee> findAllEmployees()
	{
		LOGGER.info("RETRIEVE ALL EMPLOYEE ENDPOINT REACHED");
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("find-by-id/{employeeid}")
	public Employee findEmployeeById(@PathVariable("employeeid")Long employeeId)
	{
		LOGGER.info("FIND BY ID ENDPOINT REACHED");
		return employeeService.findEmployeeByID(employeeId);
	}
	
	
	@GetMapping("save-employee")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		LOGGER.info("SAVE EMPLOYEE ENDPOINT REACHED");
		return employeeService.saveEmployee(employee);
	}
	
	@PostMapping("update-employee")
	public void updateEmployee(@RequestBody Employee employee)
	{
		employeeService.updateEmployee(employee);
	}
}
