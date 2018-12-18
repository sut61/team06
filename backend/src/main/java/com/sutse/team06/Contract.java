package com.example.demo;
import lombok.*;

import javax.persistence.*;
@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="Contract")
public class Contract {
    @Id
    @SequenceGenerator(name="contract_seq",sequenceName="contract_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="contract_seq")
    @Column(name = "contractId", unique = true, nullable = true)
    private @NonNull Long contractId;
    private @NonNull String contractName;
}