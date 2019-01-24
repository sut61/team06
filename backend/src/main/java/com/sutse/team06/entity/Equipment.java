package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
@Data
public class Equipment {
    @Id
    @SequenceGenerator(name = "Equipment_seq", sequenceName = "Equipment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Equiment_seq")
    private @NonNull Long equipmentId;
    
    @ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
    @JoinColumn(name="houseId")
    private House house;

    @ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
    @JoinColumn(name="repairid")
    private Repairs repairs;

   
  
}