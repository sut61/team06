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
import javax.validation.constraints.*;
@Entity
@Data
public class TypeSpeedInternet {
    @Id
    @SequenceGenerator(name = "TypeSpeedInternet_seq", sequenceName = "TypeSpeedInternet_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TypeSpeedInternet_seq")
    @NotNull private  Long typeSpeedId;
    
    @NotNull
    @Pattern(regexp = "[0-9\\d]{2,}[/][0-9\\d]{2,}[\\s]Mb")
    @Size(min = 6 , max = 11)
    private String typeSpeed;

    @NotNull
    @Min(value = 0)
    @Max(value = 20)
    private Integer connection;

    public TypeSpeedInternet(String typeSpeed,Integer connection){
        this.typeSpeed = typeSpeed;
        this.connection = connection;
    }
    public TypeSpeedInternet(){}
}
