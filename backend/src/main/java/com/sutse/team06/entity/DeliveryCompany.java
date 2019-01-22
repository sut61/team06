package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Entity
@Data
public class DeliveryCompany {
    @Id
    @SequenceGenerator(name = "DeliveryCompany_seq", sequenceName = "DeliveryCompany_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DeliveryCompany_seq")
    @NotNull private  Long deliComId;
    @NotNull private  String name;
  
}
