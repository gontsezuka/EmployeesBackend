package com.zukalover.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zukalover.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value="SELECT * FROM employees em WHERE em.employee_id = ?1",nativeQuery=true)
	public Employee findEmployeeByID(Long employeeId);
	
	@Query(value="DELETE FROM employees em WHERE em.employee_id = ?1",nativeQuery=true)
	public void deleteEmployeeById(Long employeeId);
}
