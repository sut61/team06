package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

import com.sutse.team06.Repository.*;
import com.sutse.team06.entity.*;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
class RentHouseController {
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private RentHouseRepository rentHouseRepository;

    @GetMapping("/house")
    public List<House> House(){
        return houseRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/renthouse")
    public List<RentHouse> RentHouse(){
        return rentHouseRepository.findAll().stream().collect(Collectors.toList());
    }
    
}