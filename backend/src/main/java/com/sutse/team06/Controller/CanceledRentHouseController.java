package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

import com.sutse.team06.Repository.*;
import com.sutse.team06.entity.*;

import java.util.List;
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

    @PostMapping("/cancelrenthouse/save/{renthouseid}/{employeeid}/{clientid}/{comment}/{canceltype}")
    public CanceledRentHouse createCanceledRentHouse(@PathVariable long renthouseid,@PathVariable long employeeid,@PathVariable long clientid,
                                    @PathVariable String comment,@PathVariable long canceltype){

        CanceledRentHouse cancel = new CanceledRentHouse();
        cancel.setComment(comment);
        cancel.setEmployee(employeeRepository.getOne(employeeid));
        cancel.setClient(clientRepository.getOne(clientid));
        cancel.setCanceltype(cancelTypeRepository.getOne(canceltype));
        cancel.setRentHouse(rentHouseRepository.getOne(renthouseid));

       /*RentHouse rentHouse = rentHouseRepository.findByRentId(renthouseid);
       rentHouse.setCanceledrentHouse(cancel);
       rentHouseRepository.save(rentHouse);*/
       
        return canceledRentHouseRepository.save(cancel);
    }
}