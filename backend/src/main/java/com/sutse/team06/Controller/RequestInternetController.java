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
    @GetMapping("/typespeed/{typeSpeedId}")
    public TypeSpeedInternet geByIdTypeSpeed(@PathVariable("typeSpeedId") Long typeSpeedId){
             return this.typeSpeedInternetRepository.findByTypeSpeedId(typeSpeedId);
    }
    @GetMapping("/checkrent/{rentid}/{housenum}")
    public  ResponseEntity<Map<String, Object>> CheckRent(@PathVariable("rentid") Long rentid,@PathVariable("housenum") Integer housenum){
            House house = this.houseRepository.findByhouseNumber(housenum);
            RentHouse rentHouse = this.rentHouseRepository.findByRentIdAndHouse(rentid,house);
            if ( rentHouse != null ) {
                 Map<String, Object> json = new HashMap<String, Object>();
                 json.put("message", "found renthouse");
                 json.put("found", true);
                 HttpHeaders headers = new HttpHeaders();
                 headers.add("Content-Type", "application/json; charset=UTF-8");
                 return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
            } else {
                 Map<String, Object> json = new HashMap<String, Object>();
                 json.put("message", "not found renthouse");
                 json.put("found", false);
                 HttpHeaders headers = new HttpHeaders();
                 headers.add("Content-Type", "application/json; charset=UTF-8");
                 return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.NOT_FOUND));   
            }
    }
    @GetMapping("/checkspeed/{typeSpeedId}")
    public  ResponseEntity<Map<String, Object>> CheckTypeSpeed(@PathVariable("typeSpeedId") Long typeSpeedId){
            try{
                    TypeSpeedInternet typespeed = this.typeSpeedInternetRepository.findByTypeSpeedId(typeSpeedId);
                    if ( typespeed.getConnection() > 0) {
                        Map<String, Object> json = new HashMap<String, Object>();
                        json.put("have", true);
                        HttpHeaders headers = new HttpHeaders();
                        headers.add("Content-Type", "application/json; charset=UTF-8");
                        return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
                    } else {
                        Map<String, Object> json = new HashMap<String, Object>();
                        json.put("have", false);
                        HttpHeaders headers = new HttpHeaders();
                        headers.add("Content-Type", "application/json; charset=UTF-8");
                        return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.NOT_FOUND));   
                    }
            } catch(Exception e) {
                        Map<String, Object> json = new HashMap<String, Object>();
                        json.put("error", e);
                        HttpHeaders headers = new HttpHeaders();
                        headers.add("Content-Type", "application/json; charset=UTF-8");
                        return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.INTERNAL_SERVER_ERROR));   
            }
    }
    @PostMapping("/requsetsave/{netuser}/{netpass}/{empid}/{rentid}/{timetypeid}/{speedid}")
    public ResponseEntity<Map<String, Object>> saveRequestNet(
        @PathVariable("netuser") String netuser,
        @PathVariable("netpass") String netpass,
        @PathVariable("empid") Long empid,
        @PathVariable("rentid") Long rentid,
        @PathVariable("timetypeid") Long timetypeid,
        @PathVariable("speedid") Long speedid
    ){
        
        try{
                Map<String, Object> json = new HashMap<String, Object>();
                Employee emp = this.employeeRepository.findByEmpId(empid);
                RentHouse renthouse = this.rentHouseRepository.findByRentId(rentid);
                TimeTypeUse timeuse = this.timeTypeUseRepository.findByTimeTypeId(timetypeid);
                TypeSpeedInternet typeSpeed = this.typeSpeedInternetRepository.findByTypeSpeedId(speedid);
                RequestInternet newreq = new RequestInternet(netuser,netpass,renthouse,emp,timeuse,typeSpeed);
                typeSpeed.setConnection(typeSpeed.getConnection()-1);
                this.requestInternetRepository.save(newreq);
                this.typeSpeedInternetRepository.save(typeSpeed);

                json.put("success", true);
                json.put("status", "saved");
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json; charset=UTF-8");
                return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));

        } catch(Exception e) {
                Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", false);
                json.put("status", "saved fail");
                return  (new ResponseEntity<Map<String, Object>>(json, null, HttpStatus.INTERNAL_SERVER_ERROR));
          }
        
    }
}