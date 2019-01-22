package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

import com.sutse.team06.Repository.FoodListRepository;
import com.sutse.team06.Repository.FoodOrderRepository;
import com.sutse.team06.entity.FoodList;
import com.sutse.team06.entity.FoodOrder;

import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;

@RestController
class FoodOrderController {
    @Autowired
    private FoodOrderRepository foodOrderRepository;
    private FoodListRepository foodListRepository;

    @GetMapping("/FoodOrder")
    public List<FoodOrder> FoodOrder(){
        return foodOrderRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/FoodList")
    public List<FoodList> FoodList(){
        return foodListRepository.findAll().stream().collect(Collectors.toList());
    }
    
}