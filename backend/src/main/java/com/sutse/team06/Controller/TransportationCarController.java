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

      @PostMapping("/TransportationCar/save/{houseid}/{client}/{carId}/{place}/{amount}/{Detail}/{employeeid}")
    public ResponseEntity<Map<String, Object>> createTransportationCar(@PathVariable long houseid,@PathVariable Long client,@PathVariable long carId,
                                    @PathVariable String place,@PathVariable long amount,@PathVariable String Detail,@PathVariable long employeeid){
        try{
            Place p = new Place();
        Map<String, Object> json = new HashMap<String, Object>();
        
        p.setPlaceName(place);
        placeRepository.save(p);
       
        TransportationCar transport = new TransportationCar();
        transport.setHouseId(houseRepository.getOne(houseid));
        transport.setCid(clientRepository.getOne(client));
        transport.setCarId(carRepository.getOne(carId));
        transport.setPlaceId(placeRepository.findByPlaceName(place));
        transport.setAmountPeople((int) amount);
        transport.setTransportDetial(Detail);
        transport.setEmpId(employeeRepository.getOne(employeeid));
        transportationCarRepository.save(transport);
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