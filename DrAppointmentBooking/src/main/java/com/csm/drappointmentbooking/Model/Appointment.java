package com.csm.drappointmentbooking.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "appt_table")
public class Appointment {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String gender;
	private Date apptDate;
	private String email;
	private String descr;
	private String address;
	private String mobile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getApptDate() {
		return apptDate;
	}

	public void setApptDate(Date apptDate) {
		this.apptDate = apptDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Appointment{" +
			   "id=" + id +
			   ", name='" + name + '\'' +
			   ", age=" + age +
			   ", gender='" + gender + '\'' +
			   ", apptDate=" + apptDate +
			   ", email='" + email + '\'' +
			   ", descr='" + descr + '\'' +
			   ", address='" + address + '\'' +
			   ", mobile='" + mobile + '\'' +
			   '}';
	}
}
