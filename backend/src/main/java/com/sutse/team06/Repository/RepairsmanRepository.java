package com.sutse.team06.Repository;
import com.sutse.team06.entity.HouseKeeper;
import com.sutse.team06.entity.RentHouse;
import com.sutse.team06.entity.Repairsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface RepairsmanRepository extends JpaRepository<Repairsman, Long> {
     Repairsman findByRepairesmanId(Long repairesmanId);
    
}