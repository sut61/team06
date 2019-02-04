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
public class ScaleTime {
    @Id
    @SequenceGenerator(name = "ScaleTime_seq", sequenceName = "ScaleTime_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ScaleTime_seq")
    @NotNull private  Long scaleTimeId;
    
    @NotNull
    private String typeScale;
}
