package com.sutse.team06.Repository;

import com.sutse.team06.entity.FoodList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface FoodListRepository extends JpaRepository<FoodList, Long> {
     FoodList findByfoodlistId(Long foodlistId);
     FoodList findByfoodlistName(String foodlistName);
}