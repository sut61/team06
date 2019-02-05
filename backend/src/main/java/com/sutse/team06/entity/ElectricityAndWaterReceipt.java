package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class ElectricityAndWaterReceipt {
    @Id
    @SequenceGenerator(name = "ElctricityAndWaterReceipt_seq", sequenceName = "ElctricityAndWaterReceipt_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ElctricityAndWaterReceipt_seq")
    private @NonNull Long ewid;
    
    
    private @NonNull Integer water;

    private @NonNull Integer electircity;

    private @NonNull Integer wesum;

    // @Pattern(regexp = "[a-zA-Z0-9\\w]{2,20}")
    @Size(min = 2, max = 20)
    private String meterchecker;
    
    // @Pattern(regexp = "[a-zA-Z0-9\\w]{2,20}")
    @Size(min = 2, max = 20)
    @Column( unique = true)
    private String sliptid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cid")
    private Client cid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="houseId")
    private House house;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Mid")
    private Mounth mid;

    
}