package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
public class Client {
    @Id
    @SequenceGenerator(name = "Client_seq", sequenceName = "Client_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Client_seq")
    private @NotNull Long cid;

    private @NotNull String name;
    @Size(min = 2, max = 20)
    private @NotNull String username;

    @Size(min = 2, max = 20)
    @Column( unique = true)
    private @NotNull String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rentId")
    private RentHouse rentHouse;
}
