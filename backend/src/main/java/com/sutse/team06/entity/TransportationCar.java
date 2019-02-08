package com.sutse.team06.entity;

import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="TransportationCar")
public class TransportationCar{
 @Id
	@SequenceGenerator(name="Transport_seq",sequenceName="Transport_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Transport_seq")
	@Column(name="TransportId",unique = true, nullable = true)
	private @NonNull Long transportId;
	private @NonNull String transportDetial;
    private @NonNull Long amountPeople;
	
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