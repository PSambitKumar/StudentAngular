package com.csm.campusdrive.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table
@Entity
public class Drive {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driveId;
    private String companyName;
    private Date driveDate;
    private Double drivePackage;
    private String hrEmail;
    private String hrMobile;
    private String companyURL;

    @OneToMany(targetEntity = StudentMaster.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "driveId", referencedColumnName = "driveId")
    private List<StudentMaster> studentMasterList;

    public int getDriveId() {
        return driveId;
    }

    public void setDriveId(int driveId) {
        this.driveId = driveId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getDriveDate() {
        return driveDate;
    }

    public void setDriveDate(Date driveDate) {
        this.driveDate = driveDate;
    }

    public Double getDrivePackage() {
        return drivePackage;
    }

    public void setDrivePackage(Double drivePackage) {
        this.drivePackage = drivePackage;
    }

    public String getHrEmail() {
        return hrEmail;
    }

    public void setHrEmail(String hrEmail) {
        this.hrEmail = hrEmail;
    }

    public String getHrMobile() {
        return hrMobile;
    }

    public void setHrMobile(String hrMobile) {
        this.hrMobile = hrMobile;
    }

    public String getCompanyURL() {
        return companyURL;
    }

    public void setCompanyURL(String companyURL) {
        this.companyURL = companyURL;
    }

    public List<StudentMaster> getStudentMasterList() {
        return studentMasterList;
    }

    public void setStudentMasterList(List<StudentMaster> studentMasterList) {
        this.studentMasterList = studentMasterList;
    }

    @Override
    public String toString() {
        return "Drive{" +
                "driveId=" + driveId +
                ", companyName='" + companyName + '\'' +
                ", driveDate=" + driveDate +
                ", drivePackage=" + drivePackage +
                ", hrEmail='" + hrEmail + '\'' +
                ", hrMobile='" + hrMobile + '\'' +
                ", companyURL='" + companyURL + '\'' +
                ", studentMasterList=" + studentMasterList +
                '}';
    }
}
