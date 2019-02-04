package com.sutse.team06.Repository;


import com.sutse.team06.entity.TypeSpeedInternet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface TypeSpeedInternetRepository extends JpaRepository<TypeSpeedInternet, Long> {
   TypeSpeedInternet findByTypeSpeedId(Long typeSpeedId);
}