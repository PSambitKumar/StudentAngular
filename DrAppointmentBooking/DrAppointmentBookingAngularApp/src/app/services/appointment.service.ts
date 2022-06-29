import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Appointment} from "../models/appointment";
import {Observable} from "rxjs";
import {TableData} from "../models/TableData";

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  private baseURL = "http://localhost:8080/appointment/v1"

  constructor(private httpClient : HttpClient) { }

  getAppointmentData() : Observable<TableData[]>{
    return this.httpClient.get<TableData[]>(`${this.baseURL + "/getAppointmentData"}`);
  }

  bookAppointment(appointment : Appointment) : Observable<TableData[]>{
    return this.httpClient.post<TableData[]>(`${this.baseURL + "/bookAppointment"}`, appointment);
  }

}
