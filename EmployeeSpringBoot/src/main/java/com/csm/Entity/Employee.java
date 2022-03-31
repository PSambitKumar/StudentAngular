package com.csm.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    @Column
    private String empCode;
    @Column
    private String empName;
    @Column
    private Long empPhn;
    @Column
    private String empEmail;
    @Column
    private Date empDob;
    @Column
    private String empGender;

    @Column
    private java.util.Date empApplyDate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country empNationality;

    @ManyToOne
    @JoinColumn(name = "relegion_id")
    private Religion empReligion;

    @ManyToOne
    @JoinColumn(name = "qual_id")
    private Qualification empQualification;

    @ManyToOne
    @JoinColumn(name = "pAdd_id")
    private PermanentAddress empPermanentAddress;

    @Column
    private String datePrint;
}
