package com.csm.campusdrive.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class StudentMaster {
    @Id
    @Column
    private String regdNo;
    private String name;
    private String gender;
    private Date dateOfAdminssion;
    private String branch;
    private String yearOfPassing;
    private Double tenthMarkPercentage;
    private Double plusTwoMarkPercentage;
    private Double cgpa;
    private String mobileNo;
    private String emialId;

    public String getRegdNo() {
        return regdNo;
    }

    public void setRegdNo(String regdNo) {
        this.regdNo = regdNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfAdminssion() {
        return dateOfAdminssion;
    }

    public void setDateOfAdminssion(Date dateOfAdminssion) {
        this.dateOfAdminssion = dateOfAdminssion;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(String yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public Double getTenthMarkPercentage() {
        return tenthMarkPercentage;
    }

    public void setTenthMarkPercentage(Double tenthMarkPercentage) {
        this.tenthMarkPercentage = tenthMarkPercentage;
    }

    public Double getPlusTwoMarkPercentage() {
        return plusTwoMarkPercentage;
    }

    public void setPlusTwoMarkPercentage(Double plusTwoMarkPercentage) {
        this.plusTwoMarkPercentage = plusTwoMarkPercentage;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmialId() {
        return emialId;
    }

    public void setEmialId(String emialId) {
        this.emialId = emialId;
    }

    @Override
    public String toString() {
        return "StudentMaster{" +
                "regdNo='" + regdNo + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfAdminssion=" + dateOfAdminssion +
                ", branch='" + branch + '\'' +
                ", yearOfPassing='" + yearOfPassing + '\'' +
                ", tenthMarkPercentage=" + tenthMarkPercentage +
                ", plusTwoMarkPercentage=" + plusTwoMarkPercentage +
                ", cgpa=" + cgpa +
                ", mobileNo='" + mobileNo + '\'' +
                ", emialId='" + emialId + '\'' +
                '}';
    }
}
