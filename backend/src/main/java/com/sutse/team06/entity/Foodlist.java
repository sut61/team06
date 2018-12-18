package com.sutse.team06.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
public class Foodlist {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long foodId;
    private String foodName;


    protected Foodlist() {}

}