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
public class RentHouse {
    @Id
    @SequenceGenerator(name = "RentHouse_seq", sequenceName = "RentHouse_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RentHouse_seq")
    private @NonNull Long rentId;
}
