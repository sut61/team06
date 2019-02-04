package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class CanceledRentHouse {
    @Id
    @SequenceGenerator(name = "CanceledRentHouse_seq", sequenceName = "CanceledRentHouse_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CanceledRentHouse_seq")
    private @NonNull Long cancelId;
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="empId")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cid")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rentId")
    private RentHouse renthouse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "canceltypeId")
    private CancelType canceltype;

}