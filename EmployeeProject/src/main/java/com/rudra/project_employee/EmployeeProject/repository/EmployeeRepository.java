package com.rudra.project_employee.EmployeeProject.repository;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.rudra.project_employee.EmployeeProject.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Employee> findAll(){
		 TypedQuery<Employee> namedQuery = entityManager.createNamedQuery("find_all_employee", Employee.class);
		 return namedQuery.getResultList();
	}
	
	public Employee update(Employee employee) {
		return entityManager.merge(employee);
	}
	
	public Employee insert(Employee employee) {
		return entityManager.merge(employee);
	}
	
	public Employee findById(Long id) {
		return entityManager.find(Employee.class, id);
	}
	
	public void deleteById(Long id) {
		Employee employee = findById(id);
		entityManager.remove(employee);
	}
}
