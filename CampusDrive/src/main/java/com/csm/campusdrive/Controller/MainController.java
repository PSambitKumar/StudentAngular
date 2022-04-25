package com.csm.campusdrive.Controller;

import com.csm.campusdrive.Model.Drive;
import com.csm.campusdrive.Model.StudentMaster;
import com.csm.campusdrive.Service.MainService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.ArrayList;
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

    @PostMapping (value = "/saveDrive")
    public String saveDrive(/*@ModelAttribute(value = "studentMaster") Drive drive1, */@RequestParam(value = "companyName", required = false)String companyName,
                                                                                       @RequestParam(value = "driveDate", required = false)Date driveDate,
                                                                                       @RequestParam(value = "drivePackage", required = false)Double drivePackage,
                                                                                       @RequestParam(value = "hrEmail", required = false)String hrEmail,
                                                                                       @RequestParam(value = "hrMobile",required = false)String hrMobile,
                                                                                       @RequestParam(value = "companyURL", required = false)String companyURL,
                                                                                       Drive drive, @RequestParam(value = "regdNo", required = false)List<String> regdNo, RedirectAttributes redirectAttributes){
        System.out.println("Inside Save Drive Method---------------->>");
        List<StudentMaster> studentMasterList = new ArrayList<>();
        System.out.println("Students RegdNo: " + regdNo);
        System.out.println(companyName + "," + driveDate + "," + drivePackage + "," + hrEmail + "," + hrMobile + "," + companyURL);
        drive.setCompanyName(companyName);
        drive.setDrivePackage(drivePackage);
        drive.setDriveDate(driveDate);
        drive.setHrEmail(hrEmail);
        drive.setHrMobile(hrMobile);
        drive.setCompanyURL(companyURL);
        for (String s : regdNo) {
            StringBuffer stringBuffer = new StringBuffer(s);
            stringBuffer.deleteCharAt(s.length()-1);
            System.out.println(stringBuffer);
            StudentMaster studentMaster = mainService.getStudentByregId(stringBuffer.toString());
            System.out.println(studentMaster);
            studentMasterList.add(studentMaster);
        }
        System.out.println(studentMasterList);
        drive.setStudentMasterList(studentMasterList);
        Drive drive1 = mainService.saveDrive(drive);
        if (drive1 != null){
            redirectAttributes.addFlashAttribute("flashMessage", "Drive Successfully Added.");
        }
        else {
            redirectAttributes.addFlashAttribute("flashMessage", "Filed To Add Drive!");
        }
        return "redirect:/makeADrive";
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
