package com.csm.drappointmentbooking.Service;

import com.csm.drappointmentbooking.Model.Appointment;

import java.sql.Date;
import java.util.List;

public interface AppointmentService {
	void saveAppointment(Appointment appointment);
	List<Date> getAllDistinctDate();
}
