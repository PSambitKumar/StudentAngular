package com.sambit.Controller;

import com.sambit.Entity.Employee;
import com.sambit.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/myApi/v1")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @ResponseBody
    @GetMapping("/getAllEmployeeDetails")
    public List<Employee> getAllEmployee(){
        logger.info("<<-------Inside Get All Employee------->>" );
        return employeeRepository.findAll();
    }

    @PostMapping(value = "/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        return employee;
    }

}
