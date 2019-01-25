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
    @GetMapping("/Client")
    public List<Client> ClientAll(){
        return clientRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/insurance/save/{name}/{type}/{price}/{insuname}")
    public  Insurance insurance(@PathVariable Long name,@PathVariable Long type,
    @PathVariable Long price,@PathVariable String insuname){
        Insurance insurance = new Insurance();
        insurance.setClient(clientRepository.getOne(name));        
        insurance.setType(insuranceTypeRepository.getOne(type));
        insurance.setPrice(insurancePriceRepository.getOne(price));
        insurance.setInsuname(insuname);
        return insuranceRepository.save(insurance);
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
    @GetMapping("/InsuranceType")
    public List<InsuranceType> InsuranceTypeAll(){
        return insuranceTypeRepository.findAll().stream().collect(Collectors.toList());
    }
    
    // Price
    @GetMapping("/InsurancePrice")
    public List<InsurancePrice> InsurancePriceAll(){
        return insurancePriceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/InsurancePriceSelect/{tid}")
    public List<InsurancePrice> InsurancePriceSelectAll(@PathVariable("tid") Long tid){
        InsuranceType type = this.insuranceTypeRepository.findByTid(tid);
        return this.insurancePriceRepository.findByType(type);
    }
   
}