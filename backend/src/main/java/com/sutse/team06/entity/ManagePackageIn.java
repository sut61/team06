package com.sutse.team06.entity;


import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
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
public class ManagePackageIn {
    @Id
    @SequenceGenerator(name = "ManagePackageIn_seq", sequenceName = "ManagePackageIn_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ManagePackageIn_seq")
    @NotNull private  Long mpInId;
    @NotNull private  String packageId;
    @NotNull private  Date date;

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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="mpInOut")
    private ManagePackageOut managePackageOut;
    
    public ManagePackageIn(String packageId,House house,Employee employee, RentHouse rentHouse,DeliveryCompany deliveryCompany){
            this.packageId = packageId;
            this.date = new Date();
            this.house = house;
            this.employee = employee;
            this.rentHouse = rentHouse;
            this.deliveryCompany = deliveryCompany;
    }
}
