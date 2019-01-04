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
public class Type {
    @Id
    @SequenceGenerator(name = "Type_seq", sequenceName = "Type_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Type_seq")
    private @NonNull Long Tid;
    private @NonNull String type;
}