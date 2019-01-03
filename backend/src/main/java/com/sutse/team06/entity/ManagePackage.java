package com.sutse.team06.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class ManagePackage {
    @Id
    @SequenceGenerator(name = "ManagePackage_seq", sequenceName = "ManagePackage_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ManagePackage_seq")
    private @NonNull Long mpId;
    private @NonNull String packageId;
    private @NonNull Date dateOut;
    private @NonNull Date dateIn;
}
