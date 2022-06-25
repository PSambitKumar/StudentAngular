package com.csm.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "gaming_zone_registration")
public class GamingZoneRegistration {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int regId;
	private String name;
	private String email;
	private String mobile;
	private Date dob;
	private String subType;
	private int subDuration;
	private double totalCost;
	private int age;
	private Date validFrom;
	private Date expiredOn;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public int getSubDuration() {
		return subDuration;
	}

	public void setSubDuration(int subDuration) {
		this.subDuration = subDuration;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getExpiredOn() {
		return expiredOn;
	}

	public void setExpiredOn(Date expiredOn) {
		this.expiredOn = expiredOn;
	}

	@Override
	public String toString() {
		return "GamingZoneRegistration{" +
			   "regId=" + regId +
			   ", name='" + name + '\'' +
			   ", email='" + email + '\'' +
			   ", mobile='" + mobile + '\'' +
			   ", dob=" + dob +
			   ", subType='" + subType + '\'' +
			   ", subDuration=" + subDuration +
			   ", totalCost=" + totalCost +
			   ", age=" + age +
			   ", validFrom=" + validFrom +
			   ", expiredOn=" + expiredOn +
			   '}';
	}


}
