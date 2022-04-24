package com.csm.campusdrive.Controller;

import com.csm.campusdrive.Model.StudentMaster;
import com.csm.campusdrive.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
