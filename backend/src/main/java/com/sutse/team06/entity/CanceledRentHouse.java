package com.sutse.team06.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.validation.constraints.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class CanceledRentHouse {
    @Id
    @SequenceGenerator(name = "CanceledRentHouse_seq", sequenceName = "CanceledRentHouse_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CanceledRentHouse_seq")
    private @NotNull Long cancelId;

    @Pattern(regexp = "[A-Za-z]{2,}")
    @Size(min = 2)
    @NotNull
    @Column(unique = true)
    private String comment;
   

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="empId")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "canceltypeId")
    private CancelType canceltype;

}