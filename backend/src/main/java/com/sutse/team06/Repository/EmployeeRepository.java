package com.sutse.team06.Repository;


import com.sutse.team06.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
     Employee findByEmpId(Long empId);
     Employee findByUsernameAndPassword(String  username,String password);
}