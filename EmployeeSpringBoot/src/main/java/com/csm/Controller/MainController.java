package com.csm.Controller;

import com.csm.Entity.*;
import com.csm.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String saveEmployee(@ModelAttribute Employee employee){
        System.out.println(employee);
        employee.setEmpApplyDate(new Date());
        int empMaxCode = employeeRepository.findMaxEmpId();
        String empCode = "VC"+String.format("%03d", empMaxCode);
        employee.setEmpCode(empCode);
        pAddressRepository.save(employee.getEmpPermanentAddress());
        employeeRepository.save(employee);
        return "employeeManagement";
    }
}
