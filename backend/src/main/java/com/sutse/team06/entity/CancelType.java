package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class CancelType {
    @Id
    @SequenceGenerator(name = "CancelType_seq", sequenceName = "CancelType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CancelType_seq")
    private @NonNull Long canceltypeId;
    private @NonNull String canceltype;

}