package com.csm.campusdrive.Repository;

import com.csm.campusdrive.Model.StudentMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentMasterRepository extends JpaRepository<StudentMaster, String> {

    List<StudentMaster> findAllByBranch(String branch);
}
