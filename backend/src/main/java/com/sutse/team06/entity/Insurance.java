package com.sutse.team06.entity;



import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Insurance {
    @Id
    @SequenceGenerator(name = "Insurance_seq", sequenceName = "Insurance_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Insurance_seq")
    private @NotNull Long iid;

    @Pattern(regexp = "[a-zA-Z]{2,20}")
    @Size(min = 2, max = 20)
    private @NotNull String insuname;

    @Column( unique = true)
    private @NotNull String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Type")
    private InsuranceType Type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Price")
    private InsurancePrice Price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cid")
    private Client Client;

    
}
