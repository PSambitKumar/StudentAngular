import { Component, OnInit } from '@angular/core';
import {Employee} from "../model/employee";
import {EmployeeService} from "../service/employee.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee : Employee = new Employee();
  updateEmployeeData : Employee = new Employee();

  constructor(private employeeService : EmployeeService, private router : Router, ) { }

  ngOnInit(): void {
  }

  viewEmployeeList(){
    this.router.navigate(["viewEmployees"]);
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(data =>{
      console.log("Success Data : " + JSON.stringify(data));
      var x = JSON.parse(JSON.stringify(data));
      if (x.status == "success"){
        alert("Inserted");
      }
    },
      error => console.log("Error Data : " + error));
  }

  onSubmitCreateEmployee(){
    const obj = JSON.stringify(this.employee);
    console.log("Data 1 : " + obj);
    this.saveEmployee();
    this.viewEmployeeList();
    this.ngOnInit();
  }

  sendData(empId : any){

  }

}
