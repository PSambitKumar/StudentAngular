package com.csm.campusdrive.Service;

import com.csm.campusdrive.Model.StudentMaster;
import com.csm.campusdrive.Repository.StudentMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MainServiceImpl implements MainService{

    @Autowired
    private StudentMasterRepository studentMasterRepository;

    @Override
    public List<StudentMaster> getAllStudent() {
        return studentMasterRepository.findAll();
    }
}
