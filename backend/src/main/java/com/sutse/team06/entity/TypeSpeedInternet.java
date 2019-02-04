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
public class TypeSpeedInternet {
    @Id
    @SequenceGenerator(name = "TypeSpeedInternet_seq", sequenceName = "TypeSpeedInternet_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TypeSpeedInternet_seq")
    @NotNull private  Long typeSpeedId;
    
    @NotNull
    private String typeSpeed;
    @NotNull
    private Integer connection;
}
