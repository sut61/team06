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
	private @NonNull Long TransportId;
	private @NonNull String TransportDetial;
    private @NonNull Long amountPeople;
	
	
	
}