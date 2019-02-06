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
import org.springframework.http.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
public class ReceiptController {
    @Autowired private MounthRepository mounthRepository;
    @Autowired private ElectricityAndWaterReceiptRepository electricityandwaterreceiptRepository;
    @Autowired private ClientRepository clientRepository;
    @Autowired private HouseRepository houseRepository;

    @GetMapping("/Mounth")
    public List<Mounth> MounthAll(){
        return mounthRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/ElectricityAndWaterReceipt")
    public List<ElectricityAndWaterReceipt> ElectricityAndWaterReceiptAll(){
        return electricityandwaterreceiptRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Clients")
    public List<Client> ClientAll(){
        return clientRepository.findAll().stream().collect(Collectors.toList());
    }

   

 @PostMapping("/electricityandwater/save/{water}/{electricity}/{mid}/{cid}/{house}/{meterchecker}/{sliptid}")
 public ResponseEntity<Map<String, Object>> createelectricityandwaterreceip(@PathVariable Integer water,@PathVariable Integer electricity,
 @PathVariable Long cid,@PathVariable Long house,@PathVariable Long mid,@PathVariable String sliptid,@PathVariable String meterchecker){
    try{
    ElectricityAndWaterReceipt ew = new ElectricityAndWaterReceipt();
    Map<String, Object> json = new HashMap<String, Object>();
    ew.setWater(water);
    ew.setElectricity(electricity);    
    ew.setCid(clientRepository.getOne(cid));
    ew.setHouse(houseRepository.getOne(house));
    ew.setMid(mounthRepository.getOne(mid));
    ew.setSliptid(sliptid);
    ew.setMeterchecker(meterchecker);
    electricityandwaterreceiptRepository.save(ew);

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