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
public class Price {
    @Id
    @SequenceGenerator(name = "Price_seq", sequenceName = "Price_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Price_seq")
    private @NonNull Long pid;
    private @NonNull String price1;
    private @NonNull String price2;
    private @NonNull String price3;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Type")
    private Type Type;
}
