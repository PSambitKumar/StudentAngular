package com.csm.drappointmentbooking.ServiceImpl;

import com.csm.drappointmentbooking.Model.Appointment;
import com.csm.drappointmentbooking.Repository.AppointmentRepository;
import com.csm.drappointmentbooking.Service.AppointmentService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentRepository appointmentRepository;

	@Override
	public void saveAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	@Override
	public List<Date> getAllDistinctDate() {
		return appointmentRepository.getAllDistinceDate();
	}
}
