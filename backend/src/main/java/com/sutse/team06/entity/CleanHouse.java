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
    @JoinColumn(name="houseId")
    @NotNull
    private House house;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rentId")
    @NotNull
    private RentHouse rentHouse;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="typehouseKeeperId")
     @NotNull
    private TypeHouseKeeper typeHouseKeeper;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="housekeeperId")
    private HouseKeeper HouseKeeper;
    

    
    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name="housekeeperName")
    // private HouseKeeper housekeeper;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name="housekeeperId")
    // private HouseKeeper housekeeper;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name="housekeeperTel")
    // private HouseKeeper housekeeper;

   



    public CleanHouse(){

    }

}