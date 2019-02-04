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
public class RequestInternet {
    @Id
    @SequenceGenerator(name = "RequestInternet_seq", sequenceName = "RequestInternet_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RequestInternet_seq")
    @NotNull private  Long reqInternetId;
    
    @NotNull
    private String netUser;
    @NotNull
    private String netPassword;

}
  