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
public class TypeHouseKeeper {
    @Id
    @SequenceGenerator(name = "TypeHouseKeeper_seq", sequenceName = "TypeHouseKeeper_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TypeHouseKeeper_seq")
    @NotNull private  Long typehouseKeeperId;
    
    @NotNull
    @Pattern(regexp="(Male|Female)")
    @Size(min = 3 ,max = 6)
    private String typehouseKeeper;

    public TypeHouseKeeper(){}
}
