package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Entity
@Data
public class ManagePackage {
    @Id
    @SequenceGenerator(name = "ManagePackage_seq", sequenceName = "ManagePackage_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ManagePackage_seq")
    private @NonNull Long mpId;
    private @NonNull String packageId;
    private @NonNull Date dateOut;
    private @NonNull Date dateIn;

    @ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
    @JoinColumn(name="houseId")
    private House house;

    @ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
    @JoinColumn(name="empId")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
    @JoinColumn(name="rentId")
    private RentHouse rentHouse;

    @ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
    @JoinColumn(name="deliComId")
    private DeliveryCompany deliveryCompany;
    
}
