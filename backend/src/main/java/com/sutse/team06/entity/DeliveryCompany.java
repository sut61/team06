package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.validation.constraints.*;

@Entity
@Data
public class DeliveryCompany {
    @Id
    @SequenceGenerator(name = "DeliveryCompany_seq", sequenceName = "DeliveryCompany_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DeliveryCompany_seq")
    @NotNull private  Long deliComId;

    @Pattern(regexp = "[A-Za-z\\s]{3,20}")
    @Size(min = 3, max = 20)
    @NotNull 
    private  String name;
  
}
