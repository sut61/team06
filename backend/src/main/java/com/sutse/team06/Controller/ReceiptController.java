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
    @Autowired private ElectricityAndWaterReceiptRepository receiptRepository;
    @Autowired private ClientRepository clientRepository;
    @Autowired private HouseRepository houseRepository;
}