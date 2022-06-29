package com.csm.drappointmentbooking.Controller;

import com.csm.drappointmentbooking.Bean.TableData;
import com.csm.drappointmentbooking.Model.Appointment;
import com.csm.drappointmentbooking.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/appointment/v1")
public class AppointmentAngularController {

	@Autowired
	private AppointmentService appointmentService;

	@ResponseBody
	@GetMapping(value = "/getAppointmentData")
	public List<TableData> getAppointmentData(){
		System.out.println("Inside Get Appointment Data----->");
		int count;
		List<TableData> tableDataList = new ArrayList<>();
		try {
			Date date = new Date(System.currentTimeMillis());
			count = appointmentService.totalAppointmentOnDate(date);
			TableData tableData = new TableData();
			tableData.setApptDate(date);
			tableData.setTotalAppt(count);
			tableDataList.add(tableData);
			for (int i = 1; i < 7; i++){
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.DATE, i);
				Date date1 =new Date(c.getTimeInMillis());
				TableData tableData1 = new TableData();
				count = appointmentService.totalAppointmentOnDate(date1);
				tableData1.setApptDate(date1);
				tableData1.setTotalAppt(count);
				tableDataList.add(tableData1);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Table Data Lists Are : " + tableDataList);
		return tableDataList;
	}

	@ResponseBody
	@PostMapping(value = "/bookAppointment")
	public List<TableData> bookAppointment(@RequestBody Appointment appointment){
		System.out.println("Appointment Details : " + appointment);
		int count;
		List<TableData> tableDataList = new ArrayList<>();
		try {
			Date checkDate = appointment.getApptDate();
			int countDate = appointmentService.totalAppointmentOnDate(checkDate);
			if (countDate <= 2){
				appointmentService.saveAppointment(appointment);
			}
			Date date = new Date(System.currentTimeMillis());
			count = appointmentService.totalAppointmentOnDate(date);
			TableData tableData = new TableData();
			tableData.setApptDate(date);
			tableData.setTotalAppt(count);
			tableDataList.add(tableData);
			for (int i = 1; i < 7; i++){
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.DATE, i);
				Date date1 =new Date(c.getTimeInMillis());
				TableData tableData1 = new TableData();
				count = appointmentService.totalAppointmentOnDate(date1);
				tableData1.setApptDate(date1);
				tableData1.setTotalAppt(count);
				tableDataList.add(tableData1);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Table Data Lists Are : " + tableDataList);
		return tableDataList;
	}

}
