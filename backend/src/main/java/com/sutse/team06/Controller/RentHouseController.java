package com.sutse.team06.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.sutse.team06.repository.*;
import com.sutse.team06.entity.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
class RentHouseController {
    @Autowired
    private HouseRepository houseRepository;
    private RentHouseRepository rentHouseRepository;

    @GetMapping("/House")
    public List<House> House(){
        return houseRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/RentHouse")
    public List<RentHouse> RentHouse(){
        return rentHouseRepository.findAll().stream().collect(Collectors.toList());
    }
    
}