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
public class HouseKeeper {
    @Id
    @SequenceGenerator(name = "HouseKeeper_seq", sequenceName = "HouseKeeper_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HouseKeeper_seq")

    private @NonNull Long housekeeperId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="houseId")
    private House house;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="renttypeId")
    private RentHouseType rentHouseType;

    

  

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name="houseKeeperId")
    // private HouseKeeper HouseKeeper;



    public HouseKeeper(){
        
    }

}