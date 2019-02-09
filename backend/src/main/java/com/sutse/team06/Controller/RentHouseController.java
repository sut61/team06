package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import com.sutse.team06.Repository.*;
import com.sutse.team06.entity.*;

import java.util.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class RentHouseController {
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private RentHouseRepository rentHouseRepository;
    @Autowired
    private RentHouseTypeRepository renthousetypeRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/house")
    public List<House> HouseAll() {
        return houseRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/renthouse")
    public List<RentHouse> RentHouseAll() {
        return rentHouseRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/renthousetype")
    public List<RentHouseType> RentHouseTypeAll() {
        return renthousetypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/client")
    public List<Client> ClientAll() {
        return clientRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/employee")
    public List<Employee> EmployeeAll() {
        return employeeRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/renthouse/save/{houseid}/{housetypesid}/{employeeid}/{resident}")
    public ResponseEntity<Map<String, Object>> createRentHouse(@PathVariable long houseid,@PathVariable long housetypesid,@PathVariable long employeeid
                                    ,@PathVariable String resident){

       try{                                 
       RentHouse rentHouse = new RentHouse();
       Map<String, Object> json = new HashMap<String, Object>();
       rentHouse.setHouse(houseRepository.getOne(houseid));
       rentHouse.setRentHouseType(renthousetypeRepository.getOne(housetypesid));
       rentHouse.setEmployee(employeeRepository.getOne(employeeid));
       rentHouse.setResident(resident);
       rentHouseRepository.save(rentHouse);
       json.put("success", true);
       json.put("status", "saved");


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
}