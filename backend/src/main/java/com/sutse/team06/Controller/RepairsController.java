package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.sutse.team06.Repository.HouseRepository;
import com.sutse.team06.Repository.RentHouseRepository;
import com.sutse.team06.Repository.RepairsRepository;
import com.sutse.team06.Repository.EquipmentRepository;
import com.sutse.team06.Repository.EmployeeRepository;
import com.sutse.team06.Repository.RepairsmanRepository;
import com.sutse.team06.entity.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class RepairsController {

    @Autowired private HouseRepository houseRepository;
    @Autowired private RentHouseRepository rentHouseRepository;
    @Autowired private EquipmentRepository equipmentRepository;
    @Autowired private RepairsRepository repairsRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private RepairsmanRepository repairsmanRepository;

     public RepairsController (HouseRepository houseRepository, RentHouseRepository rentHouseRepository, EquipmentRepository equipmentRepository, RepairsmanRepository repairsmanRepository){
        this.houseRepository = houseRepository;
        this.rentHouseRepository = rentHouseRepository;
        this.equipmentRepository = equipmentRepository;
        this.repairsmanRepository = repairsmanRepository;
    }

 

      @GetMapping("/house")
    public List<House> HouseAll(){
        return houseRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/renthouse")
    public List<RentHouse> RentHouseAll(){
        return rentHouseRepository.findAll().stream().collect(Collectors.toList());
    }


     @GetMapping("/equipment")
    public List<Equipment> EquipmentAll(){
        return equipmentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/repairsman")
    public List<Repairsman> RepairsmanAll(){
        return repairsmanRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/repair/save/{houseid}/{renthouseid}/{employeeid}/{equipmentid}/{repairsmanname}/{repairsmannumid}/{repairsmantel}/{repairsmantel2}/{repairsmanemail}")
    public Repairs createRepairs(   @PathVariable long houseid,
                                    @PathVariable long renthouseid,
                                    @PathVariable long employeeid,
                                    @PathVariable long equipmentid,
                                    @PathVariable String repairsmanname,
                                    @PathVariable String repairsmannumid,
                                    @PathVariable String repairsmantel, 
                                    @PathVariable String repairsmantel2,
                                    @PathVariable String repairsmanemail){
                                        

      Repairs repairs = new Repairs();
      Employee emp  = this.employeeRepository.findByEmpId(employeeid);
      House house = this.houseRepository.findByHouseId(houseid);
      RentHouse renthouse = this.rentHouseRepository.findByRentId(renthouseid);
      Equipment eqi = this.equipmentRepository.findByEquipmentId(equipmentid);
      repairs.setHouse(house);
      repairs.setRentHouse(renthouse);
      repairs.setEmployee(emp);
      repairs.setEquipment(eqi);

      Repairsman repairsman = new Repairsman();
      
    
      repairsman.setRepairsmanName(repairsmanname);
      repairsman.setRepairsmanNumid(repairsmannumid);
      repairsman.setRepairsmanTel(repairsmantel);
      repairsman.setRepairsmanTel2(repairsmantel2);
      repairsman.setRepairsmanEmail(repairsmanemail);
      Repairsman rman = this.repairsmanRepository.save(repairsman);
      repairs.setRepairsman(rman);
      return repairsRepository.save(repairs);
       
    }
}


