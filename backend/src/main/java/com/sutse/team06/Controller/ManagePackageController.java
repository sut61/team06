package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

import com.sutse.team06.Repository.DeliveryCompanyRepository;
import com.sutse.team06.Repository.EmployeeRepository;
import com.sutse.team06.Repository.HouseRepository;
import com.sutse.team06.Repository.RentHouseRepository;
import com.sutse.team06.Repository.ManagePackageInRepository;
import com.sutse.team06.Repository.ManagePackageOutRepository;
import com.sutse.team06.entity.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
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
    @PostMapping("/employee/auth/{username}/{password}")
    public  Employee authEmployee(@PathVariable("username") String username,@PathVariable("password") String password){
         return this.employeeRepository.findByUsernameAndPassword(username,password);
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
     public ManagePackageIn savePackageIn(    @PathVariable("empid") Long empid,
                              @PathVariable("packageid") String packageid,
                              @PathVariable("deliverid") Long deliverid,
                              @PathVariable("homenum") Integer homenum
               ){
             DeliveryCompany delier = this.deliveryCompanyRepository.findByDeliComId(deliverid);
             Employee emp  = this.employeeRepository.findByEmpId(empid);
             House house = this.houseRepository.findByhouseNumber(homenum);
             RentHouse renthouse = this.rentHouseRepository.findByHouse(house);
             
             ManagePackageIn mpIn =  new ManagePackageIn(packageid,house,emp,renthouse,delier);
             return this.managePackageInRepository.save(mpIn);
     }
     @GetMapping("/manapackagein/{hourenum}")
     public ManagePackageIn getPackageIn(@PathVariable("hourenum") Integer hourenum){
          House house =  this.houseRepository.findByhouseNumber(hourenum);
          RentHouse renthouse =  this.rentHouseRepository.findByHouse(house);
          return this.managePackageInRepository.findByRentHouse(renthouse);
     }
     @GetMapping("/manageout/{mpInId}")
     public ManagePackageOut checkPackeIn(@PathVariable("mpInId") Long mpInId){
          ManagePackageIn mpIn = this.managePackageInRepository.findByMpInId(mpInId);
          return this.managePackageOutRepository.findByMpInId(mpIn);
     }
     @PostMapping("/packageout/{receiver}/{empid}/{mpInId}")
     public ManagePackageOut savePackageOut(@PathVariable("receiver") String receiver,@PathVariable("empid") Long empid, @PathVariable("mpInId") Long mpInId){
          ManagePackageIn managein = this.managePackageInRepository.findByMpInId(mpInId);
          Employee emp = this.employeeRepository.findByEmpId(empid);

          ManagePackageOut manageout = new ManagePackageOut(receiver,emp,managein);
          ManagePackageOut out = this.managePackageOutRepository.save(manageout);

          // managein.setManagePackageOut(manageout);
          // this.managePackageInRepository.save(managein);
           
          return  out;
     }


}