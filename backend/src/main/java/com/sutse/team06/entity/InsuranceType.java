package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class InsuranceType {
    @Id
    @SequenceGenerator(name = "InsuranceType_seq", sequenceName = "InsuranceType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InsuranceType_seq")
    private @NotNull Long tid;
    @Pattern(regexp = "[a-zA-Z]{2,25}")
    @Column( unique = true)
    private @NotNull String type;
}
