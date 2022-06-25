package com.csm.drappointmentbooking.ServiceImpl;

import com.csm.drappointmentbooking.Model.Appointment;
import com.csm.drappointmentbooking.Repository.AppointmentRepository;
import com.csm.drappointmentbooking.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public void saveAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	@Override
	public List<Date> getAllDistinctDate() {
		return appointmentRepository.getAllDistinceDate();
	}

	@Override
	public int totalAppointmentOnDate(Date date) {
		return appointmentRepository.countDate(date);
	}
}
