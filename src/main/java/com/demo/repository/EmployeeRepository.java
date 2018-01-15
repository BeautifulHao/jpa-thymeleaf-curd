package com.demo.repository;

import com.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findById(Long id);

    Long deleteById(Long id);

    Employee findByEmployeeName(String employeeName);

    List<Employee> findByEmployeeNameLike(String employeeName);

    List<Employee>  findByEmployeeNameStartingWith(String employeeName);

    Page<Employee> findByAgeLessThan(int age, Pageable pageable);
}
