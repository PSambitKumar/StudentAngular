package com.csm.drappointmentbooking.Controller;

import com.csm.drappointmentbooking.Model.Appointment;
import com.csm.drappointmentbooking.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.List;

@Controller
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping(value = "/appointment")
	public String appointment(Model model){
		model.addAttribute("appointmentBooking", new Appointment());
//		List<Date> appointmentDateList = appointmentService.getAllDistinctDate();
//		System.out.println(appointmentDateList);
		return "Appointment";
	}
	@PostMapping(value = "/appointment")
	public String appointment(@ModelAttribute("appointmentBooking")Appointment appointment){
		System.out.println(appointment);
		appointmentService.saveAppointment(appointment);
		return "Appointment";
	}
}
