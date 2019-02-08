package com.sutse.team06.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="Car")
public class Car{
 @Id
	@SequenceGenerator(name="Car_seq",sequenceName="Car_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Car_seq")
	@Column(name="carId",unique = true, nullable = true)
	private @NonNull Long carId;
	private @NonNull String carType;
    
	
	
}