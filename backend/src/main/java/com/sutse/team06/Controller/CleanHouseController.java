package com.sutse.team06.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.sutse.team06.Repository.HouseRepository;
import com.sutse.team06.Repository.RentHouseRepository;
import com.sutse.team06.Repository.CleanHouseRepository;
import com.sutse.team06.Repository.HouseKeeperRepository;
import com.sutse.team06.Repository.TypeHouseKeeperRepository;
//import com.sutse.team06.Repository.EmployeeRepository;
import com.sutse.team06.entity.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CleanHouseController {

    @Autowired private HouseRepository     houseRepository;
    @Autowired private RentHouseRepository rentHouseRepository;
    @Autowired private CleanHouseRepository cleanHouseRepository;
    @Autowired private HouseKeeperRepository houseKeeperRepository;
    @Autowired private TypeHouseKeeperRepository typeHouseKeeperRepository;
    
    public CleanHouseController (HouseRepository houseRepository, RentHouseRepository rentHouseRepository,  CleanHouseRepository cleanHouseRepository, HouseKeeperRepository houseKeeperRepository){
        this.houseRepository = houseRepository;
        this.rentHouseRepository = rentHouseRepository;
        this.cleanHouseRepository = cleanHouseRepository;
        this.houseKeeperRepository = houseKeeperRepository;
    }

    @GetMapping("/houseKeeper")
    public List<HouseKeeper> HouseKeeperAll() {
        return houseKeeperRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/house-keeper-type")
    public List<TypeHouseKeeper> typeHouseKeeperAll() {
        return typeHouseKeeperRepository.findAll().stream().collect(Collectors.toList());
    }
    // {houseid: 4, renttypeId: 3, housekeepername: "sadas", housekeeperid: "sadas", housekeepertel: "asd"}
    @PostMapping("/houseKeeper/save/{houseid}/{renthouse}/{housekeepername}/{housekeepertype}/{housekeepertel}")
    public CleanHouse createHouseKeeper(@PathVariable("housekeepername") String housekeepername, 
                                        @PathVariable("housekeepertype") Long housekeepertype, 
                                        @PathVariable("housekeepertel") String housekeepertel,
                                        @PathVariable("houseid")  Long houseid,
                                        @PathVariable("renthouse") Long renthouse){
    //  RentHouse findByRentId(Long rentId);
            HouseKeeper housekeeper = new HouseKeeper();
            RentHouse renthouses = rentHouseRepository.findByRentId(renthouse);
            House  house = houseRepository.findByHouseId(houseid);
            TypeHouseKeeper keeper = typeHouseKeeperRepository.findByTypehouseKeeperId(housekeepertype);
            CleanHouse clean = new CleanHouse();
            housekeeper.setHousekeeperName(housekeepername);
            housekeeper.setHousekeeperTel(housekeepertel);
            HouseKeeper keepered = houseKeeperRepository.save(housekeeper);
            
            clean.setRentHouse(renthouses);
            clean.setHouse(house);
            clean.setTypeHouseKeeper(keeper);
            clean.setHouseKeeper(keepered);
            
            return cleanHouseRepository.save(clean);
            
    
    }

}
 

    



