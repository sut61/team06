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
@Table(name="Place")
public class Place{
 @Id
	@SequenceGenerator(name="Place_seq",sequenceName="Place_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Place_seq")
	@Column(name="PlaceId",unique = true, nullable = true)
	private @NonNull Long placeId;

	@Pattern(regexp = "[A-Za-z0-9\\s]{5,100}")
    @Size(min = 5 , max = 100)
    @NotNull
    @Column(unique = true)
	private String placeName;
    
	
	
	
}