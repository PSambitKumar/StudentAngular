package com.csm.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userId;
	private String password;
	private String imagePath;
	private String fullName;
	private String email;
	private String mobile;
	private Date dob;
	private String gender;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User{" +
			   "id=" + id +
			   ", userId='" + userId + '\'' +
			   ", password='" + password + '\'' +
			   ", imagePath='" + imagePath + '\'' +
			   ", fullName='" + fullName + '\'' +
			   ", email='" + email + '\'' +
			   ", mobile='" + mobile + '\'' +
			   ", dob=" + dob +
			   ", gender='" + gender + '\'' +
			   ", address='" + address + '\'' +
			   '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return getId() == user.getId() && getUserId().equals(user.getUserId()) && getPassword().equals(user.getPassword()) && getImagePath().equals(user.getImagePath()) && getFullName().equals(user.getFullName()) && getEmail().equals(user.getEmail()) && getMobile().equals(user.getMobile()) && getDob().equals(user.getDob()) && getGender().equals(user.getGender()) && getAddress().equals(user.getAddress());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getUserId(), getPassword(), getImagePath(), getFullName(), getEmail(), getMobile(), getDob(), getGender(), getAddress());
	}
}
