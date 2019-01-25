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
public class InsurancePrice {
    @Id
    @SequenceGenerator(name = "InsurancePrice_seq", sequenceName = "InsurancePrice_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InsurancePrice_seq")
    private @NonNull Long pid;
    private @NonNull Integer price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Type")
    private InsuranceType type;
}

