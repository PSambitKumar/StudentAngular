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

  empId : any;
  employee : Employee = new Employee();
  updateEmployeeData : Employee = new Employee();

  constructor(private employeeService : EmployeeService, private router : Router, ) { }

  ngOnInit() {
    this.employeeService.currentMessage.subscribe(data => {
      this.empId = data;
      alert("Inside 2nd Component :" + this.empId);
      console.log("Inside 2nd Component :" + this.empId);
      // this.employee = JSON.parse(JSON.stringify(data));
      // console.log("Single Employee List is : " + this.employee);
    })

    this.updateData();

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

  updateData() {
    this.employeeService.getEmployeeById(this.empId).subscribe(data => {
      alert("Success : " + JSON.stringify(data));
      console.log(data);
      this.employee = JSON.parse(JSON.stringify(data));
    })
  }

}
