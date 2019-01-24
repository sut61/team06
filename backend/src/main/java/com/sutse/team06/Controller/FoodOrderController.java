package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sutse.team06.Repository.ClientRepository;
import com.sutse.team06.Repository.EmployeeRepository;
import com.sutse.team06.Repository.FoodListRepository;
import com.sutse.team06.Repository.FoodOrderRepository;
import com.sutse.team06.Repository.HouseRepository;
import com.sutse.team06.entity.FoodList;
import com.sutse.team06.entity.FoodOrder;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class FoodOrderController {
    @Autowired
    private FoodOrderRepository foodOrderRepository;
    @Autowired
    private FoodListRepository foodListRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private HouseRepository houseRepository;

    @PostMapping("/FoodOrder/save/{employeeid}/{foodlist}/{client}/{house}")
    public FoodOrder createFoodOrder(@PathVariable long employeeid,@PathVariable long foodlist,@PathVariable Long client,
                                    @PathVariable long house){

       FoodOrder foodOrder = new FoodOrder();
        foodOrder.setHouseId(houseRepository.getOne(house));
        foodOrder.setCid(clientRepository.getOne(client));
        foodOrder.setFoodlistId(foodListRepository.getOne(foodlist));
       foodOrder.setEmpId(employeeRepository.getOne(employeeid));
       return foodOrderRepository.save(foodOrder);
       
    }
    @GetMapping("/FoodOrder")
    public List<FoodOrder> FoodOrder(){
        return foodOrderRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/FoodList")
    public List<FoodList> FoodList(){
        return foodListRepository.findAll().stream().collect(Collectors.toList());
    }
    
}