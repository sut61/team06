package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;
import com.sutse.team06.Repository.DeliveryCompanyRepository;
import com.sutse.team06.Repository.EmployeeRepository;
import com.sutse.team06.Repository.HouseRepository;
import com.sutse.team06.Repository.RentHouseRepository;
import com.sutse.team06.Repository.ManagePackageInRepository;
import com.sutse.team06.Repository.ManagePackageOutRepository;
import com.sutse.team06.Repository.ClientRepository;
import com.sutse.team06.entity.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ManagePackageController {

    @Autowired private HouseRepository houseRepository;
    @Autowired private RentHouseRepository rentHouseRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DeliveryCompanyRepository deliveryCompanyRepository;
    @Autowired private ManagePackageInRepository managePackageInRepository;
    @Autowired private ManagePackageOutRepository managePackageOutRepository;
    @Autowired private ClientRepository clientRepository;

    // house
    @GetMapping("/house/{houseid}")
    public  House getHouseById(@PathVariable("houseid") Long houseid){
         return this.houseRepository.findByHouseId(houseid);
    }
    // rent house
    @GetMapping("/renthouse/{renthouseid}")
    public  RentHouse getRentHouseById(@PathVariable("renthouseid") Long renthouseid){
         return this.rentHouseRepository.findByRentId(renthouseid);
    }
    // employee
    @GetMapping("/employee/{empid}")
    public  Employee getEmployeeById(@PathVariable("empid") Long empid){
         return this.employeeRepository.findByEmpId(empid);
    }
    @GetMapping("/renthouses/{hourenum}")
    public RentHouse getRentHouseByHomeNum(@PathVariable("hourenum") Integer hourenum){
          House house =  this.houseRepository.findByhouseNumber(hourenum);
          return this.rentHouseRepository.findByHouse(house);
    }
    @PostMapping("/employee/auth/{username}/{password}")
    public  ResponseEntity<Map<String, Object>> authEmployee(@PathVariable("username") String username,@PathVariable("password") String password){
         Employee employee =  this.employeeRepository.findByUsernameAndPassword(username,password);
          Map<String, Object> json = new HashMap<String, Object>();
              if(employee != null){
                     json.put("success", true);
                     json.put("status", "auth");
                     json.put("employee", employee);
                     return  (new ResponseEntity<Map<String, Object>>(json, null, HttpStatus.OK));
                     
              }else {
                     json.put("success", false);
                     json.put("status", "Unauth");
                     json.put("employee", "");
                    return  (new ResponseEntity<Map<String, Object>>(json, null, HttpStatus.NOT_FOUND));

              }
    }
    @PostMapping("/elient/auth/{username}/{password}")
    public  ResponseEntity<Map<String, Object>> authClient(@PathVariable("username") String username,@PathVariable("password") String password){
         Client elient =  this.clientRepository.findByUsernameAndPassword(username,password);
          Map<String, Object> json = new HashMap<String, Object>();
              if(elient != null){
                     json.put("success", true);
                     json.put("status", "auth");
                     json.put("employee", elient);
                     return  (new ResponseEntity<Map<String, Object>>(json, null, HttpStatus.OK));
                     
              }else {
                     json.put("success", false);
                     json.put("status", "Unauth");
                     json.put("employee", "");
                    return  (new ResponseEntity<Map<String, Object>>(json, null, HttpStatus.NOT_FOUND));

              }
    }
    // Divily
    @GetMapping("/delivercom/{deviComId}")
    public DeliveryCompany getDeliverComById(@PathVariable("deviComId") Long deviComId){
         return this.deliveryCompanyRepository.findByDeliComId(deviComId);
    }
    @GetMapping("/delivercom")
    public List<DeliveryCompany> getDeliverComAll(){
         return this.deliveryCompanyRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/managepackinall")
    public List<ManagePackageIn> getManageAll(){
         return this.managePackageInRepository.findAll().stream().collect(Collectors.toList());
    }
     @PostMapping("/packagein/{empid}/{packageid}/{deliverid}/{homenum}")
     public ResponseEntity<Map<String, Object>> savePackageIn(    @PathVariable("empid") Long empid,
                              @PathVariable("packageid") String packageid,
                              @PathVariable("deliverid") Long deliverid,
                              @PathVariable("homenum") Integer homenum
               ){
          try{
             DeliveryCompany delier = this.deliveryCompanyRepository.findByDeliComId(deliverid);
             Employee emp  = this.employeeRepository.findByEmpId(empid);
             House house = this.houseRepository.findByhouseNumber(homenum);
             RentHouse renthouse = this.rentHouseRepository.findByHouse(house);
             
             ManagePackageIn mpIn =  new ManagePackageIn(packageid,house,emp,renthouse,delier);
              ManagePackageIn mpInstatus = this.managePackageInRepository.save(mpIn);
              Map<String, Object> json = new HashMap<String, Object>();
              if(mpInstatus != null){
                     json.put("success", true);
                     json.put("status", "saved");
              }else {
                     json.put("success", true);
                     json.put("status", "No data");
              }
               
            
              HttpHeaders headers = new HttpHeaders();
              headers.add("Content-Type", "application/json; charset=UTF-8");
              return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
          } catch(Exception e) {
               Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", false);
                json.put("status", "saved fail");
               return  (new ResponseEntity<Map<String, Object>>(json, null, HttpStatus.INTERNAL_SERVER_ERROR));
          }
          //   return mpInstatus;
     }
     @GetMapping("/manapackagein/{hourenum}/{renthouse}")
     public List<ManagePackageIn> getPackageIn(@PathVariable("hourenum") Integer hourenum,@PathVariable("renthouse") Long renthouse){
          House house =  this.houseRepository.findByhouseNumber(hourenum);
          RentHouse renthouses =  this.rentHouseRepository.findByRentId(renthouse);
          return this.managePackageInRepository.findByRentHouseAndHouse(renthouses,house);
     }
     @GetMapping("/manageout/{mpInId}")
     public ManagePackageOut checkPackeIn(@PathVariable("mpInId") Long mpInId){
          ManagePackageIn mpIn = this.managePackageInRepository.findByMpInId(mpInId);
          return this.managePackageOutRepository.findByMpInId(mpIn);
     }
     @GetMapping("/managein/{mpInId}")
     public ManagePackageIn getPackageInbyId(@PathVariable("mpInId") Long mpInId){
          ManagePackageIn mpIn = this.managePackageInRepository.findByMpInId(mpInId);
          return mpIn;
     }
     @PostMapping("/packageout/{receiver}/{empid}/{mpInId}")
     public  ResponseEntity<Map<String, Object>> savePackageOut(@PathVariable("receiver") String receiver,@PathVariable("empid") Long empid, @PathVariable("mpInId") Long mpInId){
           try{
               ManagePackageIn managein = this.managePackageInRepository.findByMpInId(mpInId);
               Employee emp = this.employeeRepository.findByEmpId(empid);

               ManagePackageOut manageout = new ManagePackageOut(receiver,emp,managein);
               ManagePackageOut out = this.managePackageOutRepository.save(manageout);
               Map<String, Object> json = new HashMap<String, Object>();
               if(out != null){
                         json.put("success", true);
                         json.put("status", "save");
               }else {
                          json.put("success", true);
                          json.put("status", "save");
               }
                

              HttpHeaders headers = new HttpHeaders();
              headers.add("Content-Type", "application/json; charset=UTF-8");
              return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
           }
           catch(Exception e) {
               Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", false);
                json.put("status", "save fail");
               return  (new ResponseEntity<Map<String, Object>>(json, null, HttpStatus.INTERNAL_SERVER_ERROR));
          }

          // managein.setManagePackageOut(manageout);
          // this.managePackageInRepository.save(managein);
           
         
     }


}