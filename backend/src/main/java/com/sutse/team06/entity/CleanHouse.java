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
public class CleanHouse {
    @Id
    @SequenceGenerator(name = "CleanHouse_seq", sequenceName = "CleanHouse_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CleanHouse_seq")

    private @NonNull Long cleanhouseId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="renttypeId")
    private RentHouseType rentHouseType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="houseId")
    private House house;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="housekeeperId")
    private HouseKeeper housekeeper;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name="houseKeeperId")
    // private HouseKeeper HouseKeeper;



    public CleanHouse(){

    }

}