package com.sutse.team06.Repository;


import com.sutse.team06.entity.ManagePackageOut;
import com.sutse.team06.entity.ManagePackageIn;
import com.sutse.team06.entity.RentHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ManagePackageOutRepository extends JpaRepository<ManagePackageOut, Long> {
     ManagePackageOut findByMpInOut(Long mpInOut);
     ManagePackageOut findByMpInId(ManagePackageIn managePackageIn);
}