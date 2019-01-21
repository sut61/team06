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
@Table(name="FoodOrder")
public class FoodOrder{
 @Id
	@SequenceGenerator(name="foodorder_seq",sequenceName="foodorder_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="foodorder_seq")
	@Column(name="foodOrderId",unique = true, nullable = true)
    private @NonNull Long foodOrderId;
    
    //with Employee
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empId")
    private Employee empId;
    //with House
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "houseId")
    private House houseId;
    //with Client
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cid")
    private Client cid;
    
    //with Foodlist
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "FoodOrder_FoodList", 
        joinColumns = { @JoinColumn(name = "foodOrderId") }, 
        inverseJoinColumns = { @JoinColumn(name = "foodlistId") }
    )
    Set<FoodList> foodlist = new HashSet<>();
	
}