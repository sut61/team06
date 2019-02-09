package com.sutse.team06.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="FoodList")
public class FoodList{
 @Id
	@SequenceGenerator(name="foodlist_seq",sequenceName="foodlist_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="foodlist_seq")
	@Column(name="foodlistId",unique = true, nullable = true)
	private @NotNull Long foodlistId;

	@Pattern(regexp = "[^0-9]*")
    @Size(min = 2 , max = 50)
    @NotNull
    @Column(unique = true)
	private String foodlistName;
	
   
    @NotNull
	private Integer foodlistPrice;
	
	
	
}