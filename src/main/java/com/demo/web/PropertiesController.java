package com.demo.web;


import com.demo.entity.Employee;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PropertiesController {


    @Value("${spring.thymeleaf.cache}")
    private String someProperties;

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/properties")
    public ArrayList<String> showProperties(){

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(someProperties);

        return arrayList;
    }

    @RequestMapping("/employeeList")
    public List<Employee> List(){
        List<Employee> employees = employeeService.getEmployeeList();
        return employees;
    }

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
