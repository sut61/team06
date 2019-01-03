package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Insurance {
    @Id
    @SequenceGenerator(name = "Insurance_seq", sequenceName = "Insurance_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Insurance_seq")
    private @NonNull Long Iid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Type")
    private Type Type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Price")
    private Price Price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cid")
    private Client Client;
    
}
