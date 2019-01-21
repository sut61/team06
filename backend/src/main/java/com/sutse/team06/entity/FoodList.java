package com.sutse.team06.entity;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

	//with FoodOrder
	@ManyToMany(mappedBy = "foodlist")
    private Set<FoodOrder> foodorder = new HashSet<>();
}