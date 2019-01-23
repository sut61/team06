package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.sutse.team06.Repository.*;
import com.sutse.team06.entity.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
public class InsuranceController {

    @Autowired private InsuranceRepository insuranceRepository;
    @Autowired private ClientRepository clientRepository;
    @Autowired private InsurancePriceRepository insurancePriceRepository;
    @Autowired private InsuranceTypeRepository insuranceTypeRepository;

// insurance
    @GetMapping("/insurance/{iid}")
    public  Insurance getInsuranceById(@PathVariable("iid") Long iid){
     return this.insuranceRepository.findByIid(iid);
    }
// Client    
    @GetMapping("/client/{cid}")
    public  Client getClientByCid(@PathVariable("cid") Long cid){
     return this.clientRepository.findByCid(cid);
    }

    @PostMapping("/client/{name}")
    public  Client client(@PathVariable("name") String name){
         return this.clientRepository.findByName(name);
    }
  /*  @GetMapping("/client")
    public List<Client> Client(){
        return clientRepository.findAll().stream().collect(Collectors.toList());
    }*/

   // Type 
    @GetMapping("/insuranceType/{tid}")
    public InsuranceType getTypeByTid(@PathVariable("tid") Long tid){
     return this.insuranceTypeRepository.findByTid(tid);
    }
    
    // Price
    @GetMapping("/insurancePrice/{pid}")
    public InsurancePrice getTypeByPrice(@PathVariable("pid") Long pid){
     return this.insurancePriceRepository.findByPid(pid);
    }

   
}