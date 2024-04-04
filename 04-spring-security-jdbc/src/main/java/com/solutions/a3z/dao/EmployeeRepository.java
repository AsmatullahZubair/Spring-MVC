package com.solutions.a3z.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutions.a3z.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
