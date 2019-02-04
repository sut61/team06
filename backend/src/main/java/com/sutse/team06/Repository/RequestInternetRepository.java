package com.sutse.team06.Repository;


import com.sutse.team06.entity.RequestInternet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface RequestInternetRepository extends JpaRepository<RequestInternet, Long> {
   
}