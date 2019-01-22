package com.sutse.team06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sutse.team06.Repository.ClientRepository;
import com.sutse.team06.Repository.InsurancePriceRepository;
import com.sutse.team06.Repository.InsuranceTypeRepository;
import com.sutse.team06.Repository.*;
import com.sutse.team06.entity.*;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;

@SpringBootApplication
public class Team06Application {

	public static void main(String[] args) {
		SpringApplication.run(Team06Application.class, args);
	}
	@Bean
	ApplicationRunner init(	ClientRepository clientRepository,
							InsuranceTypeRepository insurancetypeRepository,
							InsurancePriceRepository insurancepriceRepository,
							DeliveryCompanyRepository deliveryCompanyRepository,
							EmployeeRepository employeeRepository
							){

		return args ->{

			//Client
			Stream.of("Best","Jump").forEach(Name ->{
				Client client = new Client();
				client.setName(Name);
				if(Name=="Best"){
					client.setUsername("Test1");
					client.setPassword("Test1");
				}
				if(Name=="Jump"){
					client.setUsername("Test2");
					client.setPassword("Test2");
				}
				clientRepository.save(client);	
			});
			//type
			Stream.of("Car","Motorcycle","Bike","Labtop").forEach(Type_of_insuance ->{
				InsuranceType type = new InsuranceType();
				type.setType(Type_of_insuance);
				insurancetypeRepository.save(type);
				InsurancePrice price = new InsurancePrice();
				if(Type_of_insuance=="Car"){
					price.setPrice1("3000 bath / 3 months");
					price.setPrice2("5500 bath / 6 months");
					price.setPrice3("11000 bath / 12 months");
					price.setType(insurancetypeRepository.getOne(1L));
					insurancetypeRepository.save(type);
					insurancepriceRepository.save(price);
				} 
				else if(Type_of_insuance=="Motorcycle"){
					price.setPrice1("1500 bath / 3 months");
					price.setPrice2("2750 bath / 6 months");
					price.setPrice3("5500 bath / 12 months");
					price.setType(insurancetypeRepository.getOne(2L));
					insurancetypeRepository.save(type);
					insurancepriceRepository.save(price);
				}
				else if(Type_of_insuance=="Bike"){
					price.setPrice1("750 bath / 3 months");
					price.setPrice2("1375 bath / 6 months");
					price.setPrice3("-");
					price.setType(insurancetypeRepository.getOne(3L));
					insurancetypeRepository.save(type);
					insurancepriceRepository.save(price);
				}
				else if(Type_of_insuance=="Labtop"){
					price.setPrice1("2000 bath / 3 months");
					price.setPrice2("3950 bath / 6 months");
					price.setPrice3("7900 bath / 12 months");
					price.setType(insurancetypeRepository.getOne(4L));
					insurancetypeRepository.save(type);
					insurancepriceRepository.save(price);
				}  
				insurancepriceRepository.save(price);
			});
			Stream.of("Thailand Post", "Kerry Express", "SCG Express", "TNT","DHL Express").forEach(delivername ->{
				  DeliveryCompany deliver = new DeliveryCompany();
				  deliver.setName(delivername);
				  deliveryCompanyRepository.save(deliver);
			});
				Employee emp = new Employee();
				emp.setName("emp");
				emp.setUsername("admin");
				emp.setPassword("admin"); 
				employeeRepository.save(emp);
			
		};
	}
	
}