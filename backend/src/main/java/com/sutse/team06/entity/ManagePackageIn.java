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
import javax.validation.constraints.*;

@Entity
@Data
public class ManagePackageIn {
    @Id
    @SequenceGenerator(name = "ManagePackageIn_seq", sequenceName = "ManagePackageIn_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ManagePackageIn_seq")
    @NotNull private  Long mpInId;

    
    @NotNull(message="Package Id must not be null to be valid")
    @Pattern(regexp = "([A-Z]{0,3}\\d{8,13})TH|(\\d{8,13})TH")
    @Size(min = 10, max = 20)
    private  String packageId;

    @NotNull 
    private  Date date;

    @NotNull(message="house id not null")
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name="houseId")
    private House house;

    @NotNull(message="empId id not null")
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name="empId")
    private Employee employee;

    @NotNull(message="empId id not null")
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name="rentId")
    private RentHouse rentHouse;

    @NotNull(message="empId id not null")
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name="deliComId")
    private DeliveryCompany deliveryCompany;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mpInOut")
    private ManagePackageOut managePackageOut;

    public ManagePackageIn(){
        
    }
    public ManagePackageIn(String packageId,House house,Employee employee, RentHouse rentHouse,DeliveryCompany deliveryCompany){
            this.packageId = packageId;
            this.date = new Date();
            this.house = house;
            this.employee = employee;
            this.rentHouse = rentHouse;
            this.deliveryCompany = deliveryCompany;
    }
}
