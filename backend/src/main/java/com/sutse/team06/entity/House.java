package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
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
    @NotNull 
    @Min(value = 1000)
    @Max(value = 9999)
    @Column(unique = true)
    private Integer  houseNumber;
    @Size( max = 25)
    private String style;
    

}
