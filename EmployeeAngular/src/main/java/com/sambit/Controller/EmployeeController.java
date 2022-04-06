package com.sambit.Controller;

import com.sambit.Entity.Employee;
import com.sambit.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/myApi/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @ResponseBody
    @GetMapping("/getAllEmployeeDetails")
    public List<Employee> getAllEmployee(){
        System.out.println("<<-------Inside Get All Employee------->>");
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }
}
