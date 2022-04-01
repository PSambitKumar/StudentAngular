package com.csm.Controller;

import com.csm.Entity.*;
import com.csm.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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
        Date applyDate = new Date();
        employee.setEmpApplyDate(applyDate);

        try {
            int empMaxCode = employeeRepository.findMaxEmpId();
            String empCode = "VC"+String.format("%03d", empMaxCode);
            employee.setEmpCode(empCode);
        }catch (Exception e){
            String empCode = "VC"+String.format("%03d", 1);
            employee.setEmpCode(empCode);
        }

        SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
        String strDate = sm.format(applyDate);
        employee.setDatePrint(strDate);

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
//        List<Employee> employeeList = employeeRepository.findAll();
//        model.addAttribute("employeeList", employeeList);
        return "/viewEmployeeManagement";
    }

//    @ResponseBody
//    @PostMapping(value = "/getDataOfTable")
//    public String getDataOfTable(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
//        System.out.println(pageNumber + "/" + pageSize);
//        return "Success";
//    }

    @ResponseBody
    @PostMapping(value = "/getDataOfTable")
    public List<Employee> getDataOfTable(@RequestParam(value = "pageNumber", required = false) int pageNumber, @RequestParam(value = "pageSize", required = false) int pageSize){
        System.out.println(pageNumber + "/" + pageSize);
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        System.out.println(pageable);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        System.out.println(employeePage);
        System.out.println(employeePage.toList());//Printing List
        return employeePage.toList();
    }

    @GetMapping(value = "/viewemployeeManagementDropdown")
    public String viewemployeeManagementDropdown(Model model){
        int totalData = employeeRepository.getTotalNoOfEmployees();
        int totalDropDown = totalData/10;
        int reminder = totalData%10;

        System.out.println("Reminder is " + reminder);

        if (reminder > 0){
            totalDropDown += totalDropDown;
        }
        System.out.println("TotalData" + totalData + ", Total Dropdown " + totalDropDown + ", Reminder " + reminder);

        model.addAttribute("totalData", totalData);
        model.addAttribute("totalDropdown", totalDropDown);
        model.addAttribute("reminder", reminder);
//        List<Employee> employeeList = employeeRepository.findAll();
//        model.addAttribute("employeeList", employeeList);
        return "viewemployeeManagementDropdown";
    }

    @ResponseBody
    @PostMapping(value = "/GetTableBodyDataAjax")
    public List<Employee> getTableBodyDataAjax(@RequestParam(value = "pageSize", required = false) int pageSize, @RequestParam(value = "pageNumber", required = false) int pageNumber){
        System.out.println(pageSize + " Sambit " + pageNumber);
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        Page<Employee> employeePage = employeeRepository.findAll(pageable) ;
        System.out.println(employeePage.toList());
        return employeePage.toList();
    }

    @GetMapping(value = "/viewemployeeManagementNumberPaging")
    public String viewemployeeManagementNumberPaging(Model model){
        int totalData = employeeRepository.getTotalNoOfEmployees();
        int totalPages = totalData/10;
        int reminder = totalData%10;
        if(reminder > 0){
         totalPages += totalPages;
        }
        model.addAttribute("totalData", totalData);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("reminder", reminder);
        return "viewemployeeManagementNumberPaging";
    }
}
