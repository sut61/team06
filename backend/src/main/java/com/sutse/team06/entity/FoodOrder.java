package com.sutse.team06.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
    //private @NonNull Date orderDate ;
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
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "foodlistId")
    private FoodList foodlistId;
    


    
	
}