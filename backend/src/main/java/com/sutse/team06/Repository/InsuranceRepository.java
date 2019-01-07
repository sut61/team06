package com.sutse.team06.repository;


import com.sutse.team06.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    Insurance findByIid(Long iid);
}