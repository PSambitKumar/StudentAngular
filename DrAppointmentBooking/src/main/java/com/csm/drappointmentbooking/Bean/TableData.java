package com.csm.drappointmentbooking.Bean;

import java.sql.Date;

public class TableData {
	private Date apptDate;
	private int totalAppt;

	public Date getApptDate() {
		return apptDate;
	}

	public void setApptDate(Date apptDate) {
		this.apptDate = apptDate;
	}

	public int getTotalAppt() {
		return totalAppt;
	}

	public void setTotalAppt(int totalAppt) {
		this.totalAppt = totalAppt;
	}

	@Override
	public String toString() {
		return "TableData{" +
			   "apptDate=" + apptDate +
			   ", totalAppt=" + totalAppt +
			   '}';
	}
}
