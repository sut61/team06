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



}