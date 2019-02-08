package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.sutse.team06.Repository.HouseRepository;
import com.sutse.team06.Repository.RentHouseRepository;
import com.sutse.team06.Repository.CleanHouseRepository;
import com.sutse.team06.Repository.HouseKeeperRepository;
//import com.sutse.team06.Repository.EmployeeRepository;
import com.sutse.team06.entity.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CleanHouseController {

    @Autowired private HouseRepository houseRepository;
    @Autowired private RentHouseRepository rentHouseRepository;

 

    // @GetMapping("/house")
    // public List<House> HouseAll(){
    //     return houseRepository.findAll().stream().collect(Collectors.toList());
    // }
    
    // @GetMapping("/renthouse")
    // public List<RentHouse> RentHouseAll(){
    //     return rentHouseRepository.findAll().stream().collect(Collectors.toList());
    // }




    // @PostMapping("/cleanhouse/save/{houseid}/{renthouseid}")
    // public CleanHouse createCleanHouse(@PathVariable long houseid,@PathVariable long renthouseid){

    //   CleanHouse cleanHouse = new CleanHouse();
    //   cleanhouse.setHouse(houseRepository.getOne(houseid));
    //   cleanHouse.setRentHouse(rentHouseRepository.getOne(renthouseid));
  
    //   return cleanHouseRepository.save(cleanhouse);
       
    // }
}


