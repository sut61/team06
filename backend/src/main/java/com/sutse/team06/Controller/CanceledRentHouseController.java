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
class CanceledRentHouseController {
    @Autowired
    private CancelTypeRepository cancelTypeRepository;
    @Autowired
    private CanceledRentHouseRepository canceledRentHouseRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RentHouseRepository rentHouseRepository;

    @GetMapping("/canceltype")
    public List<CancelType> canceltypeAll(){
        return cancelTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/cancelrenthouse")
    public List<CanceledRentHouse> cancelrenthouseAll(){
        return canceledRentHouseRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/cancelrenthouse/save/{renthouseid}/{employeeid}/{comment}/{canceltype}")
    public ResponseEntity<Map<String, Object>> createCanceledRentHouse(@PathVariable long renthouseid,@PathVariable long employeeid,
                                    @PathVariable String comment,@PathVariable long canceltype){

                                        try{
        CanceledRentHouse cancel = new CanceledRentHouse();
        Map<String, Object> json = new HashMap<String, Object>();
        cancel.setComment(comment);
        cancel.setEmployee(employeeRepository.getOne(employeeid));
        cancel.setCanceltype(cancelTypeRepository.getOne(canceltype));
        canceledRentHouseRepository.save(cancel);

       RentHouse rentHouse = rentHouseRepository.getOne(renthouseid);
       rentHouse.setCanceledrentHouse(cancel);
       rentHouseRepository.save(rentHouse);   
       canceledRentHouseRepository.save(cancel);
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