package com.csm.Controller;

import com.csm.Entity.*;
import com.csm.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    StateRepository stateRepository;
    @Autowired
    QualificationRepository qualificationRepository;
    @Autowired
    ReligionRepository religionRepository;
    @Autowired
    PAddressRepository pAddressRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/employeeManagement")
    public String employeeManagement(Model model){

        List<Country> countryList = countryRepository.findAll();
        model.addAttribute("countryList", countryList);

        List<State> stateList = stateRepository.findAll();
        model.addAttribute("stateList", stateList);

        List<Religion> religionList = religionRepository.findAll();
        model.addAttribute("religionList", religionList);

        List<Qualification> qualificationList = qualificationRepository.findAll();
        model.addAttribute("qualificationList", qualificationList);

        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);
        return "employeeManagement";
    }

    @PostMapping(value = "/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee, Model model){
        System.out.println(employee);
        employee.setEmpApplyDate(new Date());

        try {
            int empMaxCode = employeeRepository.findMaxEmpId();
            String empCode = "VC"+String.format("%03d", empMaxCode);
            employee.setEmpCode(empCode);
        }catch (Exception e){
            String empCode = "VC"+String.format("%03d", 1);
            employee.setEmpCode(empCode);
        }

        religionRepository.save(employee.getEmpReligion());
        pAddressRepository.save(employee.getEmpPermanentAddress());
        employeeRepository.save(employee);

        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);
        return "/viewEmployeeManagement";
    }

    @ResponseBody
    @GetMapping(value = "/CheckDuplicateEmployee")
    public String checkDuplicateData(@RequestParam("name") String empName){
        System.out.println(empName);
        Employee employee = employeeRepository.getByEmpName(empName);
        System.out.println(employee);
        if (employee != null)
            return "Success";
        else
            return "Fail";
    }

    @GetMapping(value = "/viewemployeeManagement")
    public String viewemployeeManagement(Model model){
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);
        return "/viewEmployeeManagement";
    }

}
