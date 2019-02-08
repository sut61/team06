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
import com.sutse.team06.Repository.CarRepository;
import com.sutse.team06.Repository.ClientRepository;
import com.sutse.team06.Repository.EmployeeRepository;
import com.sutse.team06.Repository.HouseRepository;
import com.sutse.team06.Repository.PlaceRepository;
import com.sutse.team06.Repository.TransportationCarRepository;
import com.sutse.team06.entity.Car;
import com.sutse.team06.entity.Place;
import com.sutse.team06.entity.TransportationCar;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class TransportationCarController {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private TransportationCarRepository transportationCarRepository;
   

    @GetMapping("/TransportationCar")
    public List<TransportationCar> TransportationCar(){
        return transportationCarRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Car")
    public List<Car> Car(){
        return carRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/Place")
    public List<Place> Place(){
        return placeRepository.findAll().stream().collect(Collectors.toList());
    }
   
    
}