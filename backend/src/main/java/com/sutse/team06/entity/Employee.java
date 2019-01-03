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
public class Employee {
    @Id
    @SequenceGenerator(name = "Employee_seq", sequenceName = "Employee_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Employee_seq")
    private @NonNull Long empId;
    private @NonNull String name;
    private @NonNull String username;
    private @NonNull String password;
}
