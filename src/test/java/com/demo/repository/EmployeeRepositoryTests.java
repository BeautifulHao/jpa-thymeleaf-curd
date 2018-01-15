package com.demo.repository;

import com.demo.JpaThymeleafApplication;
import com.demo.entity.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaThymeleafApplication.class)
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void test() throws Exception{

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        Employee employee = new Employee();
        employee.setEmployeeName(uuid);
        employee.setAge(32);
        employee.setPassword("123");
        employeeRepository.save(employee);

        Assert.assertEquals(32,employeeRepository.findByEmployeeName(uuid).getAge());


    }

    @Test
    public void testLike() throws Exception{
        Assert.assertTrue(employeeRepository.findByEmployeeNameLike("%fu%").size()>0);

        Assert.assertTrue(employeeRepository.findByEmployeeNameStartingWith("fu").size()>0);


        int page=1, size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Employee> employees = employeeRepository.findByAgeLessThan(100,pageable);

        Assert.assertTrue(employees.getTotalPages()>0);

    }
}
