package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class RentHouse {
    @Id
    @SequenceGenerator(name = "RentHouse_seq", sequenceName = "RentHouse_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RentHouse_seq")
    private @NotNull Long rentId;

    @Pattern(regexp = "(Mr|Ms|Mrs)[.][A-Za-z]{2,15}")
    @Size(min = 5 , max = 19)
    @NotNull
    private  String resident;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="renttypeId")
    private RentHouseType rentHouseType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="houseId")
    private House house;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="empId")
    private Employee employee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="requestInternet")
    private RequestInternet requestInternet;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancelId")
    private CanceledRentHouse canceledrentHouse;

}
