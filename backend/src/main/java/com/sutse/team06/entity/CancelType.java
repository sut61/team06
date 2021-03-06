package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.validation.constraints.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class CancelType {
    @Id
    @SequenceGenerator(name = "CancelType_seq", sequenceName = "CancelType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CancelType_seq")
    private @NotNull Long canceltypeId;
    @NotNull
    @Size(min = 4 , max = 20)
    @Column(unique = true)
    private String canceltype;

    @NotNull
    @Size(max = 25)
    private String description;

    @NotNull
    @Pattern(regexp="[0-9\\d]{2,}[-][0-9\\d]{2,}[\\s]bath")
    private String finerate;

    @NotNull
    @Max(value = 7)
    private Integer tax;
    
    @Size(max = 25)
    private String message;
}