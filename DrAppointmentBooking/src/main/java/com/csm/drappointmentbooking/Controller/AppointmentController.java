package com.csm.drappointmentbooking.Controller;

import com.csm.drappointmentbooking.Bean.TableData;
import com.csm.drappointmentbooking.Model.Appointment;
import com.csm.drappointmentbooking.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping(value = "/appointment")
	public String appointment(Model model){
		model.addAttribute("appointmentBooking", new Appointment());
		int count = 0;
		List<TableData> tableDataList = new ArrayList<>();
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
		model.addAttribute("tableDataList",tableDataList);
		return "Appointment";
	}
	@PostMapping(value = "/appointment")
	public String appointment(@ModelAttribute("appointmentBooking")Appointment appointment, Model model){
		System.out.println(appointment);
		Date checkDate = appointment.getApptDate();
		int countDate = appointmentService.totalAppointmentOnDate(checkDate);
		if (countDate <= 2){
			appointmentService.saveAppointment(appointment);
		}
		int count = 0;
		List<TableData> tableDataList = new ArrayList<>();
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
		model.addAttribute("tableDataList",tableDataList);
		return "Appointment";
	}
}
