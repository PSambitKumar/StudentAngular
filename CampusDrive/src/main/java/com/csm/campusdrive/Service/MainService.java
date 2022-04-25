package com.csm.campusdrive.Service;

import com.csm.campusdrive.Model.Drive;
import com.csm.campusdrive.Model.StudentMaster;

import java.util.List;

public interface MainService {
    List<StudentMaster> getAllStudent();
    List<StudentMaster> getAllCSEStudet(String branch);
    Drive saveDrive(Drive drive);
    StudentMaster getStudentByregId(String regId);
}
