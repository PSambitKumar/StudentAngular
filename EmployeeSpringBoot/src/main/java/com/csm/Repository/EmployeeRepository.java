package com.csm.Repository;

import com.csm.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT MAX(empId) FROM Employee ")
    int findMaxEmpId();

    @Query("SELECT  COUNT(empId) FROM Employee ")
    int getTotalNoOfEmployees();

//    List<Employee> findCustomSizeOfData(int size);

    Employee getByEmpName(String name);

}
