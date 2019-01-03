package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class DeliveryCompany {
    @Id
    @SequenceGenerator(name = "DeliveryCompany_seq", sequenceName = "DeliveryCompany_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DeliveryCompany_seq")
    private @NonNull Long deliComId;
    private @NonNull String name;
  
}
