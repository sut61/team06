package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;
import com.sutse.team06.Repository.*;
import com.sutse.team06.entity.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class RequestInternetController {

    @Autowired private RequestInternetRepository requestInternetRepository;
    @Autowired private TypeSpeedInternetRepository typeSpeedInternetRepository;
    @Autowired private TimeTypeUseRepository timeTypeUseRepository;
    @Autowired private RentHouseRepository rentHouseRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private HouseRepository houseRepository;

    @GetMapping("/typespeed")
    public List<TypeSpeedInternet> getAllTypeSpeed(){
             return this.typeSpeedInternetRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/typeusenet")
    public List<TimeTypeUse> getAlltimeTypeUse(){
             return this.timeTypeUseRepository.findAll().stream().collect(Collectors.toList());
    }
}