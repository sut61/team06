package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class ElctricityAndWaterReceipt {
    @Id
    @SequenceGenerator(name = "ElctricityAndWaterReceipt_seq", sequenceName = "ElctricityAndWaterReceipt_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ElctricityAndWaterReceipt_seq")
    private @NonNull Long ewid;
    private @NonNull Long water;
    private @NonNull Long electircity;
    private @NonNull Long wesum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cid")
    private Client cid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rentId")
    private RentHouse renthouse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Mid")
    private Mounth mid;
}