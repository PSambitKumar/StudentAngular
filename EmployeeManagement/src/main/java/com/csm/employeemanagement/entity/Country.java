package com.csm.employeemanagement.entity;

import javax.persistence.*;

@Entity
public class Country {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    @Column
    private String cname;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Country() {
    }

    public Country(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
