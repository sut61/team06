package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
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

@RestController
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

    @PostMapping("/FoodOrder/{foodOrderId}")
    public FoodOrder createFoodOrder(@RequestBody String OrderData) throws JsonParseException, IOException {

        final String decoded = URLDecoder.decode(OrderData, "UTF-8");
        OrderData = decoded;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(OrderData);

        JsonNode jsonFoodlistId = actualObj.get("MenuNameSelect");
        JsonNode jsonEmpId = actualObj.get("MeatIdSelect");
        JsonNode jsonCid = actualObj.get("CatIdSelect");
        JsonNode jsonhouseId = actualObj.get("CatIdSelect");
        
        Long cid = jsonCid.asLong();
        Long empId = jsonEmpId.asLong();
        Long foodlistId = jsonFoodlistId.asLong();
        Long houseId = jsonhouseId.asLong();
       
        FoodOrder foodOrder = new FoodOrder();
        foodOrder.setCid(clientRepository.findByCid(cid));
        foodOrder.setEmpId(employeeRepository.findByEmpId(empId));
        foodOrder.setFoodlist((Set<FoodList>) foodListRepository.findByfoodlistId(foodlistId));
        foodOrder.setHouseId(houseRepository.findByHouseId(houseId));
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