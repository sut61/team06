package com.sutse.team06.Repository;

import java.util.List;
import com.sutse.team06.entity.InsurancePrice;
import com.sutse.team06.entity.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface InsurancePriceRepository extends JpaRepository<InsurancePrice, Long> {
    InsurancePrice findByPid(Long pid);
    List<InsurancePrice> findByType(InsuranceType type);
}