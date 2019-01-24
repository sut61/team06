package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.sutse.team06.Repository.HouseRepository;
import com.sutse.team06.Repository.RentHouseRepository;
import com.sutse.team06.Repository.RepairsRepository;
import com.sutse.team06.Repository.EquipmentRepository;
import com.sutse.team06.entity.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class RepairsController {

    @Autowired private HouseRepository houseRepository;
    @Autowired private RentHouseRepository rentHouseRepository;
    @Autowired private EquipmentRepository equipmentRepository;
 

      @GetMapping("/house")
    public List<House> HouseAll(){
        return houseRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/renthouse")
    public List<RentHouse> RentHouseAll(){
        return rentHouseRepository.findAll().stream().collect(Collectors.toList());
    }


     @GetMapping("/equipment")
    public List<Equipment> EquipmentAll(){
        return equipmentRepository.findAll().stream().collect(Collectors.toList());
    }

}


