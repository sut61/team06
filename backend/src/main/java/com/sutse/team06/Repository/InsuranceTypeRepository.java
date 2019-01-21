package com.sutse.team06.repository;


import com.sutse.team06.entity.InsuranceType;
import com.sutse.team06.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, Long> {
    InsuranceType findByType(String type);
}