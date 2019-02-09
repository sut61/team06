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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Mounth {
    @Id
    @SequenceGenerator(name = "Mounth_seq", sequenceName = "Mounth_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Mounth_seq")
    private @NotNull Long mid;
    @Pattern(regexp = "[a-zA-Z]{2,20}")
    @Column( unique = true)
    private @NotNull String mounth;
}