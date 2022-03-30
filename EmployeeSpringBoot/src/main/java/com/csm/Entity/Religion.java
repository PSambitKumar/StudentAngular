package com.csm.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Religion {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    @Column
    private String rname;
}
