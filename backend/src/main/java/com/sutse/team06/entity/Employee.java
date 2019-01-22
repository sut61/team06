package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Employee {
    @Id
    @SequenceGenerator(name = "Employee_seq", sequenceName = "Employee_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Employee_seq")
    @NotNull private  Long empId;
    @NotNull private  String name;
    @NotNull private  String username;
    @NotNull private  String password;
}
