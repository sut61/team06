package com.sutse.team06.Repository;


import com.sutse.team06.entity.RentHouseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface RentHouseTypeRepository extends JpaRepository<RentHouseType, Long> {
    RentHouseType findByRenttypeId(Long renttypeId);
}