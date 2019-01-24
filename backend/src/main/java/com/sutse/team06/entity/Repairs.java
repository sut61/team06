package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.util.Date;
import java.util.Collection;

@Entity
@Getter @Setter
@ToString @EqualsAndHashCode
public class Repairs {
    @Id
    @SequenceGenerator(name = "Repair_seq", sequenceName = "Repair_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Repair_seq")
    private @NonNull Long repairsId;
 
    @ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
    @JoinColumn(name="houseId")
    private House house;

    @ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
    @JoinColumn(name="rentId")
    private RentHouse rentHouse;

    @ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
    @JoinColumn(name="equipmentId")
    private Equipment equipment;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="empId")
    private Employee employee;
     
    public Repairs(){}
   
 
}