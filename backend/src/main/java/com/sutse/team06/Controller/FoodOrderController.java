package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;
import com.sutse.team06.Repository.ClientRepository;
import com.sutse.team06.Repository.EmployeeRepository;
import com.sutse.team06.Repository.FoodListRepository;
import com.sutse.team06.Repository.FoodOrderRepository;
import com.sutse.team06.Repository.HouseRepository;
import com.sutse.team06.entity.FoodList;
import com.sutse.team06.entity.FoodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> createFoodOrder(@PathVariable long employeeid,@PathVariable long foodlist,@PathVariable Long client,
                                    @PathVariable long house){
                                    try{
        FoodOrder foodOrder = new FoodOrder();
        Map<String, Object> json = new HashMap<String, Object>();
       
        foodOrder.setHouseId(houseRepository.getOne(house));
        foodOrder.setCid(clientRepository.getOne(client));
        foodOrder.setFoodlistId(foodListRepository.getOne(foodlist));
        foodOrder.setEmpId(employeeRepository.getOne(employeeid));
        foodOrderRepository.save(foodOrder);
         HttpHeaders headers = new HttpHeaders();
         headers.add("Content-Type", "application/json; charset=UTF-8");
         return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
         }
         catch(Exception e) {
             Map<String, Object> json = new HashMap<String, Object>();
              json.put("success", false);
              json.put("status", "saved fail");
             return  (new ResponseEntity<Map<String, Object>>(json, null, HttpStatus.INTERNAL_SERVER_ERROR));
        }

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