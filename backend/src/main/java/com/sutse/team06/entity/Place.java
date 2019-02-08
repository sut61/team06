package com.sutse.team06.entity;

import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="Place")
public class Place{
 @Id
	@SequenceGenerator(name="Place_seq",sequenceName="Place_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Place_seq")
	@Column(name="PlaceId",unique = true, nullable = true)
	private @NonNull Long placeId;
	private @NonNull String placeName;
    
	
	
	
}