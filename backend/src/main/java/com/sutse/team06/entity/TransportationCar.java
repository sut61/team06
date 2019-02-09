package com.sutse.team06.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="TransportationCar")
public class TransportationCar{
 	@Id
	@SequenceGenerator(name="transport_seq",sequenceName="transport_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transport_seq")
	
	private @NotNull Long transportId;
	
	   @Pattern(regexp ="[^\\d]{5,100}")
       @Size(min = 5 , max = 100)
       @NotNull
       @Column(unique = true)
	   private String transportDetial;

	   private @NotNull Integer amountPeople;
	 //with Car
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "carId")
	 private Car carId;

	  //with Place
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "placeId")
	  private Place placeId;

	  //with Client
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "cid")
	  private Client cid;

	  //with House
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "houseId")
	  private House houseId;

	   //with Employee
	   @ManyToOne(fetch = FetchType.EAGER)
	   @JoinColumn(name = "empId")
	   private Employee empId;
	   
       

	
}