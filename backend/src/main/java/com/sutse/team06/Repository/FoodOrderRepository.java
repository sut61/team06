package com.sutse.team06.Repository;


import com.sutse.team06.entity.FoodOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
     FoodOrder findByfoodOrderId(Long foodOrderId);
}