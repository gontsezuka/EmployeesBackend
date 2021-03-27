package com.zukalover.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zukalover.model.Employee;
import com.zukalover.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * @author Gontse Mochoana
	 * Description: This method retrieves all employees in database
	 * @return
	 */
	public List<Employee> findAllEmployees()
	{
		List<Employee> employeeList = new ArrayList<>();
		try {
			employeeList =  employeeRepository.findAll();
		}catch(Exception e)
		{
			LOGGER.info(e.getMessage());
		}
		return employeeList;
	}
	
	/**
	 * @author Gontse Mochoana
	 * Description: This method retrieves a single employe by ID
	 * @param employeeId
	 * @return
	 */
	public Employee findEmployeeByID(Long employeeId)
	{
		Employee employee = new Employee();
		try {
			
			employee = employeeRepository.findEmployeeByID(employeeId);
		}catch(Exception e)
		{
			LOGGER.error(e.getMessage());
		}
		return employee;
	}
	
	/**
	 * @author Gontse Mochoana
	 * Description: This method saves an employee and return the employee 
	 * @param employee
	 * @return
	 */
	public Employee saveEmployee(Employee employee)
	{
		Employee employeeReturn = new Employee();
		try {
			employee.setEmployeeCode(UUID.randomUUID().toString());
			employeeReturn = employeeRepository.save(employee);
		}catch(Exception e)
		{
			
		}
		return employeeReturn;
	}
	
	/**
	 * @author Gontse Mochoana
	 * Description: This method deletes an employe by table ID
	 * @param employeeId
	 */
	public void deleteEmployee(Long employeeId)
	{
		Employee employee = new Employee();
		try {
			employee = employeeRepository.findEmployeeByID(employeeId);
			if(employee!=null)
			{
				
			}
		}catch(Exception e)
		{
			LOGGER.error(e.getMessage());
		}
		
		
	}
	
	/**
	 * @author Gontse Mochoana
	 * Description: This method updates employee by ID
	 * @param employeeId
	 */
	public void updateEmployee(Employee employeeToUpdate)
	{
		Employee employee = new Employee();
		Employee newEmployee = new Employee();
		try {
			employee = employeeRepository.findEmployeeByID(employeeToUpdate.getEmployeeId());
			if(employee!=null)
			{
				newEmployee.setEmail(employeeToUpdate.getEmail());
				newEmployee.setEmployeeCode(employeeToUpdate.getEmployeeCode());
				newEmployee.setEmployeeId(employeeToUpdate.getEmployeeId());
				newEmployee.setJobTitle(employeeToUpdate.getJobTitle());
				newEmployee.setName(employeeToUpdate.getName());
				newEmployee.setPhone(employeeToUpdate.getPhone());
				newEmployee.setUrl(employeeToUpdate.getUrl());
				employeeRepository.save(newEmployee);
			}
		}catch(Exception e)
		{
			LOGGER.error(e.getMessage());
		}
	}
	
	/**
	 * @author Gontse Mochoana
	 * 
	 * @param employee
	 * @return
	 */
	public Employee updateReturn(Employee employee)
	{
		Employee employeeReturned = new Employee();
		try {
			employee = employeeRepository.save(employee);
		}catch(Exception e)
		{
			LOGGER.error(e.getMessage());
		}
		return employeeReturned;
	}
}
