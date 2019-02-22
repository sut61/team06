package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;


@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class RentHouseType {
    @Id
    @SequenceGenerator(name = "RentHouseType_seq", sequenceName = "RentHouseType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RentHouseType_seq")
    private @NotNull Long renttypeId;
    @NotNull
    @Pattern(regexp = "[0-9\\d]{1,2}[\\s](day|month|days|months)")
    @Size(min = 4 , max = 9)
    @Column(unique = true)
    private String description;
    
    @Size(max = 25)
    private String additional;

    

}
