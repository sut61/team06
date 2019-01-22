package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Client {
    @Id
    @SequenceGenerator(name = "Client_seq", sequenceName = "Client_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Client_seq")
    private @NonNull Long cid;
    private @NonNull String name;
    private @NonNull String username;
    private @NonNull String password;
}
