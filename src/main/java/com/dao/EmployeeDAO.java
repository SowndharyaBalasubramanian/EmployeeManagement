package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDAO {
List<Employee> getAllEmployees();
Employee getEmployeeById(int id);
boolean addEmployee(Employee emp);
boolean updateEmployee(Employee emp);
boolean deleteEmployee(int id);
}
