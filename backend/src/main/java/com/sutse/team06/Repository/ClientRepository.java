package com.sutse.team06.Repository;


import com.sutse.team06.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByCid(Long cid);
    Client findByName(String name);
    Client findByUsernameAndPassword(String username,String password);
}