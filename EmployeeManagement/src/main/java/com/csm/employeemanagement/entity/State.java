package com.csm.employeemanagement.entity;

import javax.persistence.*;

@Entity
@Table
public class State {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    @Column
    private String sname;
    @Column
    private int countryId;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "State{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}