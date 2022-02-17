package com.axonactive.jpa.service;

import com.axonactive.jpa.controller.request.EmployeeRequest;
import com.axonactive.jpa.entities.Employee;
import com.axonactive.jpa.enumerate.Gender;
import lombok.Getter;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(int id);
    List<Employee> getEmployeeByDepartment(int departmentId);
    Employee addEmployee(int departmentId, EmployeeRequest employeeRequest);
    Employee updateEmployee(int employeeId, EmployeeRequest employeeRequest);
    List<Employee> getEmployeeByGender(Gender gender);
    List<Employee> getEmployeeByAge(int age);
}
