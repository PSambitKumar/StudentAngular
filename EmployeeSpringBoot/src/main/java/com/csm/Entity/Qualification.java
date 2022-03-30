package com.csm.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Qualification {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qualId;
    @Column
    private String qualName;
}
