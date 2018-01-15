package com.demo.web;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class EmployeeController {

    @Resource
    EmployeeService employeeService;

    @RequestMapping("/list")
    public String List(Model model){
        List<Employee> employees = employeeService.getEmployeeList();
        model.addAttribute("employees",employees);
//        System.out.println("热部署测试！");
        return "employee/list";
    }


    @RequestMapping("/toAdd")
    public String toAdd() {
        return "employee/employeeAdd";
    }


    @RequestMapping("/add")
    public String add(Employee employee){
        employeeService.save(employee);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        Employee employee=employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee/employeeEdit";
    }

    @RequestMapping("/edit")
    public String edit(Employee employee) {
        employeeService.edit(employee);
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        employeeService.delete(id);
        return "redirect:/list";
    }



}
