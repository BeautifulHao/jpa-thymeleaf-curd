package com.demo.service;

import com.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList();

    Employee findEmployeeById(long id);

    void save(Employee employee);

    void edit(Employee employee);

    void delete(long id);

    List<Employee> getEmloyeeListByName(String employeeLikes);

    List<Employee>  findByEmployeeNameStartingWith(String employeeName);

    Page<Employee> findByAgeLessThan(int age, Pageable pageable);
}
