package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Entity
@Data
public class ManagePackageOut {
    @Id
    @SequenceGenerator(name = "ManagePackageOut_seq", sequenceName = "ManagePackageOut_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ManagePackageOut_seq")
    @NotNull private  Long mpInOut;
    @NotNull private  String receiver;
    @NotNull private  Date date;


    @ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
    @JoinColumn(name="empId")
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="mpInId")
    private ManagePackageIn managePackageIn;

    private  ManagePackageOut(){}

    public ManagePackageOut(String receiver, Employee employee,ManagePackageIn managePackageIn){
        this.receiver = receiver;
        this.date = new Date();
        this.employee = employee;
        this.managePackageIn = managePackageIn;
    }
 
}
