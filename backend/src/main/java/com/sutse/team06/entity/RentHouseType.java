package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;


@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class RentHouseType {
    @Id
    @SequenceGenerator(name = "RentHouseType_seq", sequenceName = "RentHouseType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RentHouseType_seq")
    private @NonNull Long renttypeId;
    private @NonNull String description;

    

}
