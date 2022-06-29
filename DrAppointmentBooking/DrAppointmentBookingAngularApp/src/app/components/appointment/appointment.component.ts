import { Component, OnInit } from '@angular/core';
import {Appointment} from "../../models/appointment";
import {TableData} from "../../models/TableData";
import {AppointmentService} from "../../services/appointment.service";

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  appointment : Appointment = new Appointment();
  appointmentList : TableData[] = [];

  constructor(private appointmentService : AppointmentService) { }

  ngOnInit(): void {
    this.getAppointmentData();
  }

  bookAppointment(){
    console.log(this.appointment);
    this.appointmentService.bookAppointment(this.appointment).subscribe(data => {
      // console.log(data);
      this.appointmentList = data;
      console.log(this.appointmentList)
    });
  }

  getAppointmentData(){
    this.appointmentService.getAppointmentData().subscribe( data => {
      this.appointmentList = data;
      console.log(this.appointmentList);
    })
  }

}
