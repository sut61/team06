package com.sutse.team06.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


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
	private @NotNull Long carId;

	@Pattern(regexp = "[A-Za-z\\s]{2,50}")
    @Size(min = 2 , max = 50)
    @NotNull
    @Column(unique = true)
	private String carType;
    
	
	
}