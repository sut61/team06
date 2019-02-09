package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class House {
    @Id
    @SequenceGenerator(name = "House_seq", sequenceName = "House_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "House_seq")
    private @NotNull Long houseId;
    private @NotNull Integer  houseNumber;

    

}
