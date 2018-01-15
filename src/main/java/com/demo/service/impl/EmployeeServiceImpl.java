package com.demo.service.impl;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void edit(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(long id) {
        employeeRepository.delete(id);
    }

    @Override
    public List<Employee> getEmloyeeListByName(String employeeLikes) {
        return employeeRepository.findByEmployeeNameLike(employeeLikes);
    }

    @Override
    public List<Employee> findByEmployeeNameStartingWith(String employeeName) {
        return employeeRepository.findByEmployeeNameStartingWith(employeeName);
    }

    @Override
    public Page<Employee> findByAgeLessThan(int age, Pageable pageable) {
        return employeeRepository.findByAgeLessThan(age,pageable);
    }
}
