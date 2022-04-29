import { Component, OnInit } from '@angular/core';
import {Employee} from "../model/employee";
import {EmployeeService} from "../service/employee.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employeeList: Employee[] = [];
  employee : Employee = new Employee();

  constructor(private employeeService : EmployeeService, private router : Router) { }

  ngOnInit(): void {
    this.getEmployeeData();
  }

  private getEmployeeData(){
    this.employeeService.getEmployeeDetails().subscribe(data => {
      console.log(data);
      this.employeeList = data;
    });
  }

  editEmployee(empId: any){
    console.log(empId);
    this.employeeService.getEmployeeById(empId).subscribe( data =>{
      // alert("Success : " + JSON.stringify(data));
      console.log(data);
      this.employee = JSON.parse(JSON.stringify(data));
      this.router.navigate(["createEmployee"]);
      // this.employeeService.exchanegeData(JSON.stringify(data));
      this.employeeService.exchanegeData(empId);
    },
      error => alert("Error : " + error));
  }

  deleteEmployee(empId: any){
    console.log(empId);
  }

}
