package com.csm.campusdrive.Controller;

import com.csm.campusdrive.Model.Drive;
import com.csm.campusdrive.Model.StudentMaster;
import com.csm.campusdrive.Service.MainService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping(value = "/makeADrive")
    public String makeADrive(Model model){
        List<StudentMaster> studentMasterList = mainService.getAllStudent();
        System.out.println(studentMasterList);
        return "makeADrive";
    }

    @GetMapping (value = "/saveDrive")
    public String saveDrive(Drive drive){
        System.out.println("Inside Save Drive Method---------------->>");
//        System.out.println("Data2" + list1);
        List<StudentMaster> cseStudentList = mainService.getAllCSEStudet("CSE");
        drive.setDriveDate(new Date());
        drive.setDrivePackage(400000.00);
        drive.setCompanyName("CSM Technologies");
        drive.setCompanyURL("www.csm.tech");
        drive.setHrEmail("hr.mail@csm.co.in");
        drive.setHrMobile("90909090");
        drive.setStudentMasterList(cseStudentList);
        Drive drive1  = mainService.saveDrive(drive);
        System.out.println(drive1);
        return null;
    }

    @ResponseBody
    @PostMapping ("/getCSEStudents")
    public List<StudentMaster> getCSEStudents(@RequestParam("cse")String cse){
        System.out.println("Inside CSE Search Method---------------->>");
        List<StudentMaster> cseStudentList = mainService.getAllCSEStudet(cse);
        System.out.println(cseStudentList);
        return cseStudentList;
    }
}
