package com.sutse.team06.repository;


import com.sutse.team06.entity.ManagePackageIn;
import com.sutse.team06.entity.RentHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ManagePackageInRepository extends JpaRepository<ManagePackageIn, Long> {
     ManagePackageIn findByMpInId(Long mpInId);
     ManagePackageIn findByRentHouse(RentHouse rentHouse);
}