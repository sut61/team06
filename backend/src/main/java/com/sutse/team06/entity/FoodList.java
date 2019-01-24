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
@Table(name="FoodList")
public class FoodList{
 @Id
	@SequenceGenerator(name="foodlist_seq",sequenceName="foodlist_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="foodlist_seq")
	@Column(name="foodlistId",unique = true, nullable = true)
	private @NonNull Long foodlistId;
	private @NonNull String foodlistName;

	
	
	// @ManyToOne(fetch = FetchType.LAZY)  
	// @JoinColumn(name= "foodOrderId")      
	// private FoodOrder foodOrder;
}