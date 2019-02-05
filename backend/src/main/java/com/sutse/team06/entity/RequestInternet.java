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
import javax.persistence.Column;
import javax.validation.constraints.*;

@Entity
@Data
public class RequestInternet {
    @Id
    @SequenceGenerator(name = "RequestInternet_seq", sequenceName = "RequestInternet_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RequestInternet_seq")
    @NotNull private  Long reqInternetId;
    
    @NotNull(message = "Net name not null")
    @Size(min = 6)
    @Pattern(regexp = "[A-Za-z\\w0,9\\d]{6,}")
    @Column(unique = true)
    private String netUser;

    @NotNull(message = "Net password not null")
    @Size(min = 6)
    @Pattern(regexp = "[A-Za-z\\w0,9\\d@$!%*#?&]{6,}")
    @Column(unique = true)
    private String netPassword;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rentHouse")
    private RentHouse rentHouse;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    private TimeTypeUse timeTypeUse;

    @ManyToOne(fetch = FetchType.LAZY)
    private TypeSpeedInternet typeSpeedInternet;
   
    public RequestInternet(){}
    public RequestInternet(String netUser,String netPassword,RentHouse rentHouse,Employee employee,TimeTypeUse timeTypeUse,TypeSpeedInternet typeSpeedInternet){
        this.netUser = netUser;
        this.netPassword = netPassword;
        this.rentHouse = rentHouse;
        this.employee =   employee;
        this.timeTypeUse = timeTypeUse;
        this.typeSpeedInternet = typeSpeedInternet;
    }
}
  