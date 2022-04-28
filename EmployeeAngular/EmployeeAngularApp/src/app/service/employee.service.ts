import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../model/employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = "http://localhost:8083/myApi/v1";

  constructor(private httpClient : HttpClient) { }

  getEmployeeDetails() : Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseUrl+"/getAllEmployeeDetails"}`);
  }

  createEmployee(employee : Employee) : Observable<object>{
    return this.httpClient.post<object>(`${this.baseUrl+"/createEmployee"}`, employee);
  }

  getEmployeeById(empId : any) : Observable<object>{
    return this.httpClient.get<object>(`${this.baseUrl+"/getEmployeeById/"}`+empId);
  }
}
