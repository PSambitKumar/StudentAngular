package com.csm.drappointmentbooking.Repository;

import com.csm.drappointmentbooking.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	@Query("SELECT DISTINCT(a.apptDate) from Appointment a")
	List<Date> getAllDistinceDate();

	@Query("SELECT COUNT (a.apptDate) FROM Appointment a WHERE  a.apptDate=:date")
	int countDate(@Param("date")Date date);
}
