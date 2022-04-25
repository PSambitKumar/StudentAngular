package com.csm.campusdrive.Service;

import com.csm.campusdrive.Model.Drive;
import com.csm.campusdrive.Model.StudentMaster;
import com.csm.campusdrive.Repository.DriveRepository;
import com.csm.campusdrive.Repository.StudentMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MainServiceImpl implements MainService{

    @Autowired
    private StudentMasterRepository studentMasterRepository;
    @Autowired
    private DriveRepository driveRepository;

    @Override
    public List<StudentMaster> getAllStudent() {
        return studentMasterRepository.findAll();
    }

    @Override
    public List<StudentMaster> getAllCSEStudet(String branch) {
        return studentMasterRepository.findAllByBranch(branch);
    }

    @Override
    public Drive saveDrive(Drive drive) {
        return driveRepository.save(drive);
    }
}
