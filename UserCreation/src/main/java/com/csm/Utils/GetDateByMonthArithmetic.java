package com.csm.Utils;

import java.sql.Date;
import java.util.Calendar;

public class GetDateByMonthArithmetic {
	public static Date getDate(int monthDuration){
		long millis=System.currentTimeMillis();
		Date currDate = new Date(millis);
		Calendar c = Calendar.getInstance();
		c.setTime(currDate);
		c.add(Calendar.MONTH, +monthDuration);
		System.out.println("Data" + c.getTime());
		return new Date(c.getTimeInMillis());
	}
}
