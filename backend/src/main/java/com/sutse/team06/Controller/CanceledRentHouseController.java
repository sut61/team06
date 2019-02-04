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
class RentHouseController {
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private RentHouseRepository rentHouseRepository;
    @Autowired
    private RentHouseTypeRepository renthousetypeRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    
}