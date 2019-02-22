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
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

@Entity
@Getter @Setter
public class Repairsman {
    @Id
    @SequenceGenerator(name = "Repairsman_seq", sequenceName = "Repairsman_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Repairsman_seq")
    private @NonNull Long repairesmanId;

    @NotNull
    @Pattern(regexp="[A-Za-z]{5,10}")
    private String repairsmanName;

    @NotNull
    @Pattern(regexp="[R][0-5]{5}")
    private String repairsmanNumid;
   

    @NotNull
    @Pattern(regexp="(08|09|06)[0-9]{8}")
    private String repairsmanTel;

    @NotNull
    @Pattern(regexp="(02)[0-9]{7}")
    private String repairsmanTel2;

    @NotNull
    @Pattern(regexp="[A-Za-z0-9]{4,}[@](gmail)(.)(com)")
    private String repairsmanEmail;



    
    public Repairsman(){
        
    }

}