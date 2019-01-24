package com.sutse.team06.Repository;


import com.sutse.team06.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface HouseRepository extends JpaRepository<House, Long> {
     House findByHouseId(Long houseId);
     House findByhouseNumber(long  house);
}